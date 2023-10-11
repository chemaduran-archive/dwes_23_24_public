package _3_factory;

public class FacturaIvaSuperreducido extends Factura {
    @Override
    public double getImporteIva() {
        return getImporte() * 1.04;
    }
}
