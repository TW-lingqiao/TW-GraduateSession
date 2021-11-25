package D01_origin;

import java.util.Scanner;

public class Shop {
  public static void main(String[] arg) {
    final Scanner scanner = new Scanner(System.in);
    System.out.println("欢迎选购手机");
    System.out.println("----------");
    System.out.println("请选择品牌：");
    System.out.println("【1】苹果");
    System.out.println("【2】小米");
    String brand = scanner.nextLine();
    brand = convertToValue(brand, new String[]{"苹果", "小米"});
    testExit(brand);

    System.out.println("----------");
    System.out.println("请选择产品类型：");
    System.out.println("【1】手机");
    System.out.println("【2】电脑");
    String productFamily = scanner.nextLine();
    productFamily = convertToValue(productFamily, new String[]{"手机", "电脑"});
    testExit(productFamily);

    System.out.println("----------");
    System.out.println("请选择颜色：");
    System.out.println("【1】深空灰");
    System.out.println("【2】玫瑰金");
    System.out.println("【3】银色");
    String color = scanner.nextLine();
    color = convertToValue(color, new String[]{"深空灰", "玫瑰金", "银色"});
    testExit(color);

    Product myProduct = new Product(brand, productFamily, color);
    make(myProduct);
    System.out.println("----------");
    System.out.println("完成选购手机");
  }

  public static String convertToValue(String brand, String[] values) {
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

  private static void make(Product product) {
    System.out.println(product.getBrand() +"已获取完成");
    System.out.println(product.getProductFamily() +"已获取完成");
    System.out.println(product.getColor() +"已获取完成");
    System.out.println("产品：" + product.getBrand() + product.getColor() + product.getProductFamily() + "已制作完成。");
  }
}

