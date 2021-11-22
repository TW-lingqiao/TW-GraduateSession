package factory;

import product.Product;
import product.pc.PC;
import product.phone.Phone;

public interface AbstractFactory {
  Product produce();
  Phone makePhone();
  PC makePC();
}
