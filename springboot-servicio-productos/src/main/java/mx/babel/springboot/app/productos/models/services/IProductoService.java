package mx.babel.springboot.app.productos.models.services;

import java.util.List;

import mx.babel.springboot.app.productos.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	public Producto findById(Long id);
}
