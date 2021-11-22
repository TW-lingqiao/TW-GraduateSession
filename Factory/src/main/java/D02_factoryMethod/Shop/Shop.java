package D02_factoryMethod.Shop;

import D02_factoryMethod.factory.AbstractFactory;
import D02_factoryMethod.factory.AppleFactory;
import D02_factoryMethod.factory.XiaomiFactory;

import java.util.Scanner;
import java.util.stream.Stream;

public class Shop {
  public static void main(String[] arg) {
    final Scanner scanner = new Scanner(System.in);
    System.out.println("欢迎选购手机");

    String[] brandOptions = new String[]{"苹果", "小米"};
    String brand = askForPreferences("品牌", brandOptions, scanner);

    String[] colorOptions = new String[]{"深空灰", "玫瑰金", "银色"};
    String color = askForPreferences("颜色", colorOptions, scanner);

    AbstractFactory factory = null;
    switch (brand) {
      case "苹果":
        factory = new AppleFactory(color);
        break;
      case "小米":
        factory = new XiaomiFactory(color);
        break;
      default:
        break;
    }
    assert factory != null;
    factory.makePhone();
    System.out.println("----------");
    System.out.println("完成选购手机");
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
      System.out.println("抱歉，您的选择本店无法提供");
      return "Exit";
    }
  }

  private static void testExit(String item) {
    if(item.equals("Exit")) {
      System.exit(0);
    }
  }
}
