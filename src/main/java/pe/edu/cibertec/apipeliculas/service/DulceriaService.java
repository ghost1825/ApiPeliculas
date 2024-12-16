package pe.edu.cibertec.apipeliculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apipeliculas.model.Dulceria;
import pe.edu.cibertec.apipeliculas.repository.DulceriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DulceriaService {

    @Autowired
    private DulceriaRepository dulceriaRepository;

    public List<Dulceria> listarProductos() {
        return dulceriaRepository.findAll();
    }

    public Optional<Dulceria> obtenerProductoPorId(Long id) {
        return dulceriaRepository.findById(id);
    }

    public Dulceria guardarProducto(Dulceria dulceria) {
        return dulceriaRepository.save(dulceria);
    }

    public Dulceria actualizarProducto(Long id, Dulceria dulceria) {
        return dulceriaRepository.findById(id).map(existing -> {
            existing.setCodigo(dulceria.getCodigo());
            existing.setNombre(dulceria.getNombre());
            existing.setPrecio(dulceria.getPrecio());
            existing.setDescripcion(dulceria.getDescripcion());
            existing.setImagen(dulceria.getImagen());
            return dulceriaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public void eliminarProducto(Long id) {
        dulceriaRepository.deleteById(id);
    }
}