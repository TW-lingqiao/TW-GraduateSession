package D03_abstractFactory.Shop;

import D03_abstractFactory.factory.AbstractFactory;
import D03_abstractFactory.factory.AppleFactory;
import D03_abstractFactory.factory.XiaomiFactory;
import D03_abstractFactory.product.Product;

import java.util.Scanner;
import java.util.stream.Stream;

public class Shop {
    public static void main(String[] arg) {
      final Scanner scanner = new Scanner(System.in);
      System.out.println("欢迎选购电子产品");

      String[] brandOptions = new String[]{"苹果", "小米"};
      String brand = askForPreferences("品牌", brandOptions, scanner);

      String[] productFamilyOptions = new String[]{"手机", "电脑"};
      String productFamily = askForPreferences("产品族", productFamilyOptions, scanner);

      String[] colorOptions = new String[]{"深空灰", "玫瑰金", "银色"};
      String color = askForPreferences("颜色", colorOptions, scanner);

      AbstractFactory factory = findFactory(brand, productFamily, color);

      Product product = factory.produce();

      handoverToCustomer(product);
    }

  private static AbstractFactory findFactory(String brand, String productFamily, String color) {
    AbstractFactory factory = null;
    switch (brand) {
      case "苹果":
        factory = new AppleFactory(color, productFamily);
        break;
      case "小米":
        factory = new XiaomiFactory(color, productFamily);
        break;
      default:
        break;
    }
    assert factory != null;
    return factory;
  }

  private static String askForPreferences(String type, String[] options, Scanner scanner) {
    System.out.println("----------");
    System.out.println("请选择" + type + "：");
    Stream.iterate(1, i -> i + 1)
            .limit(options.length)
            .forEach(i -> System.out.println("【" + i + "】" + options[i-1]));
    String choice = scanner.nextLine();
    choice = convertToValue(choice, options);
    testExit(choice);
    return choice;
  }

  private static String convertToValue(String brand, String[] values) {
    int number = Integer.parseInt(brand);
    try {
      return values[number - 1];
    } catch (Exception e) {
      System.out.println("----------");
      System.out.println("抱歉，您的选择本店无法提供");
      return "Exit";
    }
  }

  private static void testExit(String item) {
    if(item.equals("Exit")) {
      System.exit(0);
    }
  }

  private static void handoverToCustomer(Product product) {
    System.out.println("----------");
    System.out.println("感谢选购" + product.getDescription() + "，欢迎下次光临");
  }
}
