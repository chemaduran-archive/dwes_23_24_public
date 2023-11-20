package velazquez._4_productlinescrud.model;

import java.io.Serializable;

public class ProductLine implements Serializable {

  // Estamos supondiendo que una variable de tipo cadena tiene
  // tamaño suficiente para albergar esos campos
  // NOTA: Estamos obviando el campo IMAGE que sería UN BLOB (objeto binario
  // guardado directamente en la base de datos
  private String productLine;
  private String textDescription;
  private String htmlDescription;

  public ProductLine() {}

  public ProductLine(String productLine, String textDescription, String htmlDescription) {
    super();
    this.productLine = productLine;
    this.textDescription = textDescription;
    this.htmlDescription = htmlDescription;
  }

  public String getProductLine() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }

  public String getTextDescription() {
    return textDescription;
  }

  public void setTextDescription(String textDescription) {
    this.textDescription = textDescription;
  }

  public String getHtmlDescription() {
    return htmlDescription;
  }

  public void setHtmlDescription(String htmlDescription) {
    this.htmlDescription = htmlDescription;
  }
}
