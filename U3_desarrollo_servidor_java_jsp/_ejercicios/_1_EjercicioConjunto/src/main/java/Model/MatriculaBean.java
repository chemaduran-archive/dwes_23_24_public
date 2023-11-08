package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatriculaBean implements Serializable {
    private String nombre;
    private String apellidos;
    private String email;
    private String curso;
    private List<String> asignaturas;

    public MatriculaBean() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "MatriculaBean{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", curso='" + curso + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
