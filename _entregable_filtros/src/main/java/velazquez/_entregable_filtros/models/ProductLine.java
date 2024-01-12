package velazquez._entregable_filtros.models;

public class ProductLine {
  String productLine;
  String textDescription;
  String htmlDescription;

  public ProductLine() {}

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

  @Override
  public String toString() {
    return "ProductLine{"
        + "productLine='"
        + productLine
        + '\''
        + ", textDescription='"
        + textDescription
        + '\''
        + ", htmlDescription='"
        + htmlDescription
        + '\''
        + '}';
  }
}
