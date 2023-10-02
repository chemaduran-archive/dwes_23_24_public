package _3_factory;

public class FactoriaFacturas  {
  public static Factura getFactura(String tipo) {
    if (tipo.equals("iva")) {
      return new FacturaIva();
    } else if(tipo.equals("reducido")){
      return new FacturaIvaReducido();
    } else if(tipo.equals("superreducido")){
      return new FacturaIvaSuperreducido();
    }
    return null;
  }

}
