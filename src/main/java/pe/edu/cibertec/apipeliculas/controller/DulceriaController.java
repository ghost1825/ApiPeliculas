package pe.edu.cibertec.apipeliculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apipeliculas.model.Dulceria;
import pe.edu.cibertec.apipeliculas.service.DulceriaService;

import java.util.List;

@RestController
@RequestMapping("/api/dulceria")
public class DulceriaController {

    @Autowired
    private DulceriaService dulceriaService;

    @GetMapping
    public List<Dulceria> listarProductos() {
        return dulceriaService.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dulceria> obtenerProductoPorId(@PathVariable Long id) {
        return dulceriaService.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dulceria guardarProducto(@RequestBody Dulceria dulceria) {
        return dulceriaService.guardarProducto(dulceria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dulceria> actualizarProducto(@PathVariable Long id, @RequestBody Dulceria dulceria) {
        try {
            return ResponseEntity.ok(dulceriaService.actualizarProducto(id, dulceria));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        dulceriaService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}