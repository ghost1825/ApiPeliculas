package pe.edu.cibertec.apipeliculas.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apipeliculas.model.Pelicula;
import pe.edu.cibertec.apipeliculas.service.PeliculaService;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
class PeliculaController {
    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return service.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable int id) {
        return service.getPeliculaById(id);
    }

    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return service.createPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable int id, @RequestBody Pelicula pelicula) {
        return service.updatePelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable int id) {
        service.deletePelicula(id);
    }
}
