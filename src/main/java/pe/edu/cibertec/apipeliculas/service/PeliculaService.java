package pe.edu.cibertec.apipeliculas.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.apipeliculas.model.Pelicula;
import pe.edu.cibertec.apipeliculas.repository.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<Pelicula> getAllPeliculas() {
        return repository.findAll();
    }

    public Pelicula getPeliculaById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pelicula no encontrada"));
    }

    public Pelicula createPelicula(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    public Pelicula updatePelicula(int id, Pelicula pelicula) {
        Pelicula existingPelicula = getPeliculaById(id);
        existingPelicula.setTitulo(pelicula.getTitulo());
        existingPelicula.setDescripcion(pelicula.getDescripcion());
        existingPelicula.setImagen(pelicula.getImagen());
        existingPelicula.setGenero(pelicula.getGenero());
        existingPelicula.setDirector(pelicula.getDirector());
        existingPelicula.setDuracion(pelicula.getDuracion());
        existingPelicula.setAnio(pelicula.getAnio());
        existingPelicula.setPrecio(pelicula.getPrecio());
        return repository.save(existingPelicula);
    }

    public void deletePelicula(int id) {
        repository.deleteById(id);
    }

}
