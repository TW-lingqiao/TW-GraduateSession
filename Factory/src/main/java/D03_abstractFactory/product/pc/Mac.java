package D03_abstractFactory.product.pc;

public class Mac extends PC {
  public Mac(String color) {
    this.make(color);
  }

  @Override
  public void make(String color) {
    System.out.println("产品：苹果" + color + "电脑已制作完成。");
  }

  @Override
  public String getDescription() {
    return "Mac";
  }
}
