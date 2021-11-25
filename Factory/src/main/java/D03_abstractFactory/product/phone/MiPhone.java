package D03_abstractFactory.product.phone;

public class MiPhone extends Phone {
  public MiPhone(String color) {
    this.make(color);
  }
  @Override
  public void make(String color) {
    System.out.println("产品：小米" + color + "手机已制作完成。");
  }

  @Override
  public String getDescription() {
    return "MiPhone";
  }
}
