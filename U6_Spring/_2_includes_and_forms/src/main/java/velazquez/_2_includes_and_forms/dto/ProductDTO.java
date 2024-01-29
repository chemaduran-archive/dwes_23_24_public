package velazquez._2_includes_and_forms.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
  private String productCode;
  private String productName;
  private String productDescription;

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }
}
