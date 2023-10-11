package _4_di._4_ejercicio_trenes;

import _4_di._4_ejercicio_trenes.maquinaria.Locomotora;

public class Main {
    public static void main(String[] args){
//        Mecanico mecanico = new Mecanico("juanito", "871236", Mecanico.Especialidad.HIDRAULICA, 78);
//        Locomotora locomotora = new Locomotora();
//        locomotora.setMecanico(mecanico);
//        locomotora.muestraMecanico();
        MecanicoInyector mecanicoInyector = new MecanicoInyector();
        Locomotora locomotora = mecanicoInyector.getLocomotora();
    }
}
