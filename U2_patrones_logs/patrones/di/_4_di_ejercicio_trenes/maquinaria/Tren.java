package _4_di._4_ejercicio_trenes.maquinaria;

import _4_di._4_ejercicio_trenes.personal.Maquinista;

import java.util.ArrayList;

public class Tren {
// están formados por una locomotora y un máximo de 5 vagones.
// Cada tren tiene asignado un maquinista que es responsable de él.
    private Locomotora locomotora;
    private ArrayList<Vagon> vagones;
    private Maquinista maquinista;

    public Tren(Locomotora locomotora, ArrayList<Vagon> vagones, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.vagones = vagones;
        this.maquinista = maquinista;
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public ArrayList<Vagon> getVagones() {
        return vagones;
    }

    public void setVagones(ArrayList<Vagon> vagones) {
        this.vagones = vagones;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }

    @Override
    public String toString() {
        return "Tren{" +
                "locomotora=" + locomotora +
                ", vagones=" + vagones +
                ", maquinista=" + maquinista +
                '}';
    }
}
