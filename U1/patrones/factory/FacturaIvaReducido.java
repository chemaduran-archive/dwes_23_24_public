package _3_factory;

public class FacturaIvaReducido extends Factura {
    @Override
    public double getImporteIva() {
        return getImporte() * 1.10;
    }
}
