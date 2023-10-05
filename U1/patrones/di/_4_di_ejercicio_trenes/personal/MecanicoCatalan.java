package _4_di._4_ejercicio_trenes.personal;

public class MecanicoCatalan extends Mecanico {

    public MecanicoCatalan(String nombre, String tlfno, Especialidad especialidad, int edad) {
        super(nombre, tlfno, especialidad, edad);
    }

    @Override
    public String acento() {
        return "Amnistía";
    }
}
