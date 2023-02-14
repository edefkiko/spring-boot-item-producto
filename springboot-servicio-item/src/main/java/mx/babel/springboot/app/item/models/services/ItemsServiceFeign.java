package mx.babel.springboot.app.item.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import mx.babel.springboot.app.item.clients.ProductoClienteRest;
import mx.babel.springboot.app.item.models.Item;
import mx.babel.springboot.app.item.models.Producto;

@Service("serviceFeign")
public class ItemsServiceFeign implements ItemService{

    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Item> findAll() {
        return clienteFeign.listar().stream().map(p-> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Producto producto = clienteFeign.detalle(id);
		
		return new Item(producto, cantidad);
    }
    
}
