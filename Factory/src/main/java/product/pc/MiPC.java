package product.pc;

public class MiPC extends PC {
  public MiPC(String color) {
    this.make(color);
  }

  @Override
  public void make(String color) {
    System.out.println("产品：小米" + color + "电脑已制作完成。");
  }
}
