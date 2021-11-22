package D02_factoryMethod.factory;

import D02_factoryMethod.product.MiPhone;
import D02_factoryMethod.product.Phone;

public class XiaomiFactory implements AbstractFactory{
  private final String color;
  public XiaomiFactory(String color) {
    this.color = color;
  }

  @Override
  public Phone makePhone() {
    System.out.println("Xiaomi商标已获取完成");
    System.out.println(color +"已获取完成");
    System.out.println("组装材料已获取完成");
    return new MiPhone(color);
  }
}
