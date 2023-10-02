package _3_factory;

public class main {
  public static void main(String[] args) {
    Factura factura = FactoriaFacturas.getFactura("iva");
    factura.setId(1);
    factura.setImporte(1000);
    System.out.println("El importe con IVA es: "
            + factura.getImporteIva());
  }
}
