package velazquez._examen_trimestral.model;

public class Product {
  private String productName;
  private String productCode;
  private String productLine;
  private String productScale;
  private String productVendor;
  private String productDescription;
  private int quantityInStock;
  private Double buyPrice;
  private Double msrp;

  public Product() {}

  public Product(
      String productName,
      String productCode,
      String productLine,
      String productScale,
      String productVendor,
      String productDescription,
      int quantityInStock,
      Double buyPrice,
      Double msrp) {
    this.productName = productName;
    this.productCode = productCode;
    this.productLine = productLine;
    this.productScale = productScale;
    this.productVendor = productVendor;
    this.productDescription = productDescription;
    this.quantityInStock = quantityInStock;
    this.buyPrice = buyPrice;
    this.msrp = msrp;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductLine() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }

  public String getProductScale() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }

  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }

  public Double getMsrp() {
    return msrp;
  }

  public void setMsrp(Double msrp) {
    this.msrp = msrp;
  }

  @Override
  public String toString() {
    return "Product{"
        + "productName='"
        + productName
        + '\''
        + ", productCode='"
        + productCode
        + '\''
        + ", productLine='"
        + productLine
        + '\''
        + ", productScale='"
        + productScale
        + '\''
        + ", productVendor='"
        + productVendor
        + '\''
        + ", productDescription='"
        + productDescription
        + '\''
        + ", quantityInStock="
        + quantityInStock
        + ", buyPrice="
        + buyPrice
        + ", msrp="
        + msrp
        + '}';
  }
}
