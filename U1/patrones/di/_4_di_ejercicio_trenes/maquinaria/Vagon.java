package _4_di._4_ejercicio_trenes.maquinaria;

public class Vagon {
    // tienen una capacidad máxima de carga (en kilos),
    // una capacidad actual (carga en un momento dado),
    // y el tipo de mercancía con el que están cargados.
    private double capacidad_carga;
    private double capacidad_actual;
    private String tipo_mercancia;

    public Vagon(double capacidad_carga, double capacidad_actual, String tipo_mercancia) {
        this.capacidad_carga = capacidad_carga;
        this.capacidad_actual = capacidad_actual;
        this.tipo_mercancia = tipo_mercancia;
    }

    public double getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(double capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }

    public double getCapacidad_actual() {
        return capacidad_actual;
    }

    public void setCapacidad_actual(double capacidad_actual) {
        this.capacidad_actual = capacidad_actual;
    }

    public String getTipo_mercancia() {
        return tipo_mercancia;
    }

    public void setTipo_mercancia(String tipo_mercancia) {
        this.tipo_mercancia = tipo_mercancia;
    }

    @Override
    public String toString() {
        return "Vagon{" +
                "capacidad_carga=" + capacidad_carga +
                ", capacidad_actual=" + capacidad_actual +
                ", tipo_mercancia='" + tipo_mercancia + '\'' +
                '}';
    }
}
