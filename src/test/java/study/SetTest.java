package study;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("Set의 크기를 구한다.")
  void getSetSize(){
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("Set에 특정값이 포함되어 있는지 확인한다.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  void containsTest(int input){
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("123은 true, 45는 false")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
  void containsTest2(String input, String expected){
    System.out.println(input + " " + expected);
    String[] in = input.split(",");
    List<Integer> list = Stream.of(in).map(o -> Integer.parseInt(o)).collect(toList());
    assertEquals(numbers.containsAll(list), Boolean.parseBoolean(expected));
  }

}
