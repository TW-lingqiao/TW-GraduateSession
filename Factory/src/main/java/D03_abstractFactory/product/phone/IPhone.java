package D03_abstractFactory.product.phone;

public class IPhone extends Phone {
  public IPhone(String color) {
    this.make(color);
  }
  @Override
  public void make(String color) {
    System.out.println("产品：苹果" + color + "手机已制作完成。");
  }
}
