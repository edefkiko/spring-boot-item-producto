package mx.babel.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.babel.springboot.app.item.models.Item;
import mx.babel.springboot.app.item.models.Producto;
import mx.babel.springboot.app.item.models.services.ItemService;

@RestController
public class ItemController {
    
    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id, cantidad);
    }
    
    public Item metodoAlternativo(@PathVariable Long id, @PathVariable Integer cantidad){

        Item item = new Item();
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Cámara sony");
        producto.setPrecio(500.00);
        item.setCantidad(cantidad);
        item.setProducto(producto);

        return item;
    }


}
