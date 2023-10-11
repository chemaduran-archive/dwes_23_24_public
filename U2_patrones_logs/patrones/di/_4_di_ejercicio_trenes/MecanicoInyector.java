package _4_di._4_ejercicio_trenes;

import _4_di._4_ejercicio_trenes.maquinaria.Locomotora;
import _4_di._4_ejercicio_trenes.personal.Mecanico;
import _4_di._4_ejercicio_trenes.personal.MecanicoCatalan;

public class MecanicoInyector {
    public Locomotora getLocomotora() {
    Mecanico mecanico = new MecanicoCatalan("pepita", "888", Mecanico.Especialidad.FRENOS, 45);
    Locomotora locomotora = new Locomotora();
    locomotora.setMecanico(mecanico);
    return locomotora;
    }
}
