package D02_factoryMethod.factory;

import D02_factoryMethod.product.IPhone;
import D02_factoryMethod.product.Phone;

public class AppleFactory implements AbstractFactory {
  private final String color;
  public AppleFactory(String color) {
    this.color = color;
  }

  @Override
  public Phone makePhone() {
    System.out.println("Apple商标已获取完成");
    System.out.println(color +"已获取完成");
    System.out.println("组装材料已获取完成");
    return new IPhone(color);
  }
}