package D02_factoryMethod.product;

public class MiPhone implements Phone {
  public MiPhone(String color) {
    this.make(color);
  }
  @Override
  public void make(String color) {
    System.out.println("产品：小米" + color + "手机已制作完成。");
  }
}
