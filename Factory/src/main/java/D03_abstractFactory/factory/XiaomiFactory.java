package D03_abstractFactory.factory;

import D03_abstractFactory.product.pc.PC;
import D03_abstractFactory.product.phone.MiPhone;
import D03_abstractFactory.product.phone.Phone;
import D03_abstractFactory.product.Product;
import D03_abstractFactory.product.pc.MiPC;

public class XiaomiFactory implements AbstractFactory {
  private final String color;
  private final String productFamily;
  public XiaomiFactory(String color, String productFamily) {
    this.color = color;
    this.productFamily = productFamily;
  }

  @Override
  public Product produce() {
    switch (productFamily) {
      case "手机":
        return makePhone();
      case "电脑":
        return makePC();
      default:
        return null;
    }
  }

  public Phone makePhone() {
    prepareForMake();
    System.out.println("已获取小米手机其他拼装元件");
    return new MiPhone(color);
  }

  public PC makePC() {
    prepareForMake();
    System.out.println("已获取小米电脑其他拼装元件");
    return new MiPC(color);
  }

  private void prepareForMake() {
    System.out.println("Xiaomi商标已获取完成");
    System.out.println(color + "已获取完成");
    System.out.println("组装材料已获取完成");
  }
}
