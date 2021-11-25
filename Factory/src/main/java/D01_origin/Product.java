package D01_origin;

public class Product {
  private final String brand;
  private final String productFamily;
  private final String color;
  public Product(String brand, String productFamily, String color) {
    this.brand = brand;
    this.productFamily = productFamily;
    this.color = color;
  }

  public String getBrand() {
    return brand;
  }

  public String getColor() {
    return color;
  }

  public String getProductFamily() {
    return productFamily;
  }
}
