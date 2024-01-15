package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;
import java.io.Serializable;


@Entity
public class Categoria implements Serializable, Identifiable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
