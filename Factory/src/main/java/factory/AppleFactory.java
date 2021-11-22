package factory;

import product.Product;
import product.pc.Mac;
import product.pc.PC;
import product.phone.*;

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

  @Override
  public Phone makePhone() {
    prepareForMake();
    System.out.println("已获取苹果手机其他拼装元件");
    return new IPhone(color);
  }

  @Override
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