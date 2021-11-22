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

  public void make() {
    System.out.println(brand +"已获取完成");
    System.out.println(productFamily +"已获取完成");
    System.out.println(color +"已获取完成");
    System.out.println("产品：" + brand + color + productFamily + "已制作完成。");
  }
}
