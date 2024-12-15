package pe.edu.cibertec.apipeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.apipeliculas.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
