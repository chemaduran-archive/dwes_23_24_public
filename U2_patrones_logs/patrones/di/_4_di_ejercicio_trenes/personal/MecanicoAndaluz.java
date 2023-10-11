package _4_di._4_ejercicio_trenes.personal;

public class MecanicoAndaluz extends Mecanico {

    public MecanicoAndaluz(String nombre, String tlfno, Especialidad especialidad, int edad) {
        super(nombre, tlfno, especialidad, edad);
    }

    @Override
    public String acento() {
        return "Qué paza coone";
    }
}
