package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Calculation extends IOTest {

  @BeforeEach
  void init(){
    systemIn("2 + 3 * 4 / 2");
    stringCalculation();
  }

  @Test
  @DisplayName("문자열계산기")
  void stringCalculation(){
    Scanner scanner = new Scanner(System.in);

    while(scanner.hasNextLine()){
      String value = scanner.nextLine();

      String[] values = value.split(" ");
      int  result = Integer.parseInt(values[0]);

      for (int i = 1; i < values.length-1; i+=2) {
        result = calc(result, Integer.parseInt(values[i+1]), values[i].charAt(0));
      }
      assertThat(result).isEqualTo(10);
    }

  }

  private int calc(int a, int b, char o){
    switch (o) {
      case '+':
        return a+b;
      case '-':
        return a-b;
      case '*':
        return a*b;
      case '/':
        return a/b;
    }

    return 0;
  }
}
