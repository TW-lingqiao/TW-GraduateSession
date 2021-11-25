package D01_origin.factory;

import D01_origin.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
  @Test
  void should_get_correct_choice_according_to_given_number() {

    String inputNumber = "1";
    String[] values = new String[]{"测试1", "测试2"};
    String result = Shop.convertToValue(inputNumber, values);
    assertEquals("测试1", result);
  }

  @Test
  void should_throw_error_if_given_number_is_out_of_range() {
    String inputNumber = "3";
    String[] values = new String[]{"测试1", "测试2"};
    String result = Shop.convertToValue(inputNumber, values);
    assertEquals("Exit", result);
  }
}
