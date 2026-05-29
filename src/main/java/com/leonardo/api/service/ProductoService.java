package com.leonardo.api.service;

import com.leonardo.api.entity.Producto;
import com.leonardo.api.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() { return repo.findAll(); }

    public Producto buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return repo.findByCategoria(categoria.toUpperCase());
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    public Producto crear(Producto producto) {
        return repo.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto existing = buscarPorId(id);
        existing.setNombre(datos.getNombre());
        existing.setDescripcion(datos.getDescripcion());
        existing.setPrecio(datos.getPrecio());
        existing.setStock(datos.getStock());
        existing.setCategoria(datos.getCategoria() != null ? datos.getCategoria().toUpperCase() : existing.getCategoria());
        return repo.save(existing);
    }

    public void eliminar(Long id) {
        buscarPorId(id); // Verifica que existe
        repo.deleteById(id);
    }
}
