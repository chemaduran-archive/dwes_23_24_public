package _4_di._4_ejercicio_trenes.personal;

public abstract class Mecanico {
    // nombre completo, tlfno y especialidad (frenos, hidráulica)
    public enum Especialidad {FRENOS, HIDRAULICA};

    private String nombre;
    private String tlfno;
    private Especialidad especialidad;
    private int edad;

    public abstract String acento();

    public Mecanico(String nombre, String tlfno, Especialidad especialidad, int edad) {
        this.nombre = nombre;
        this.tlfno = tlfno;
        this.especialidad = especialidad;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlfno() {
        return tlfno;
    }

    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "nombre='" + nombre + '\'' +
                ", tlfno='" + tlfno + '\'' +
                ", especialidad=" + especialidad +
                '}';
    }
}
