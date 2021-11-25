package D03_abstractFactory.factory;

import D03_abstractFactory.product.pc.Mac;
import D03_abstractFactory.product.pc.PC;
import D03_abstractFactory.product.phone.IPhone;
import D03_abstractFactory.product.phone.Phone;
import D03_abstractFactory.product.Product;

public class AppleFactory implements AbstractFactory {
  private final String color;
  private final String productFamily;

  public AppleFactory(String color, String productFamily) {
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
    System.out.println("已获取苹果手机其他拼装元件");
    return new IPhone(color);
  }

  public PC makePC() {
    prepareForMake();
    System.out.println("已获取苹果电脑其他拼装元件");
    return new Mac(color);
  }

  private void prepareForMake() {
    System.out.println("Apple商标已获取完成");
    System.out.println(color + "已获取完成");
    System.out.println("组装材料已获取完成");
  }
}