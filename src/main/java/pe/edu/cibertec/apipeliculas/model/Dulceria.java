package pe.edu.cibertec.apipeliculas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dulceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(length = 500)
    private String descripcion;

    @Column
    private String imagen; // URL de la imagen
}