package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pokemon implements Serializable, Identifiable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String imagen;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="HabilidadPokemon", joinColumns={@JoinColumn(name="IdPokemon")}, inverseJoinColumns={@JoinColumn(name="IdHabilidad")})
    private Set<Habilidad> habilidades = new HashSet<>();

    @OneToOne(
            mappedBy = "pokemon",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private EstadisticasPokemon estadisticasPokemon;

    public void setEstadisticasPokemon(EstadisticasPokemon estadisticasPokemon) {
        estadisticasPokemon.setPokemon(this);
        this.estadisticasPokemon = estadisticasPokemon;
    }

    public void removeEstadisticasPokemon(EstadisticasPokemon estadisticasPokemon) {
        if (this.estadisticasPokemon != null) {
            estadisticasPokemon.setPokemon(null);
            this.estadisticasPokemon = null;
        }
    }

    public EstadisticasPokemon getEstadisticasPokemon() {
        return estadisticasPokemon;
    }


//    public void addHabilidad(Habilidad habilidad) {
//        this.habilidades.add(habilidad);
//        habilidad.setPokemon(this);
//    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

//    public Long getIdCategoria() {
//        return idCategoria;
//    }
//
//    public void setIdCategoria(Long idCategoria) {
//        this.idCategoria = idCategoria;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(nombre, pokemon.nombre) && Objects.equals(descripcion, pokemon.descripcion) && Objects.equals(imagen, pokemon.imagen) && Objects.equals(estadisticasPokemon, pokemon.estadisticasPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, imagen, estadisticasPokemon);
    }
}
