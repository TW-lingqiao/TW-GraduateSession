package D02_factoryMethod.product;

public class IPhone implements Phone {
  public IPhone(String color) {
    this.make(color);
  }
  @Override
  public void make(String color) {
    System.out.println("产品：苹果" + color + "手机已制作完成。");
  }
}
