package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Nested;


/**
 * Cars라는 클래스는 Car라는 타입을 List 형태에 저장하는 일급 컬렉션입니다.
 */

@DisplayName("Cars Class")
public class CarsTest {

  @DisplayName("Car 타입을 List 형태에 저장하는 일급 컬렉션 생성 테스트입니다.")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 객체생성(List<String> nameList) {
    new Cars(nameList);
  }

  @DisplayName("Car 타입을 List 형태에 저장하는 일급 컬렉션 생성 테스트이며 실패하는 경우입니다.")
  @ParameterizedTest
  @MethodSource({"provideWrongNameList"})
  void 객체생성실패(List<String> wrongNameList) {
    assertThrows( IllegalArgumentException.class, ()-> new Cars(wrongNameList));
  }

  @DisplayName("when new")
  @Nested
  static class WhenNew{

    private Cars cars;
    private List<String> givenNames = Arrays.asList("test1", "test2","test3","test4","test5","test6","test7","test8","test9");
    private List<Integer> givenNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
    private List<Integer> expectResult = Arrays.asList(0, 0, 0, 0, 1,1,1,1,1);

    @BeforeEach
    void setUp(){
      cars = new Cars(givenNames);
    }

    @DisplayName("차량 목록 조회")
    @Test
    void 차량목록조회(){
      assertThat(cars.getNumberOfCar()).isEqualTo(givenNames.size());
    }

    @DisplayName("조건에 따른 차량 전진")
    @Test
    void 차량_전진_테스트() {
      cars.play(givenNumbers);
      for(int i = 0; i < cars.getNumberOfCar(); i++){
        assertThat(cars.getCarList().get(i).getPosition()).isEqualTo(expectResult.get(i));
      }
    }

    @DisplayName("게임 종료 여부 판단")
    @Test
    void goals(){
      int givenEndCount = 1;
      cars.play(givenNumbers);
      assertThat(cars.goals(givenEndCount)).isTrue();
    }

  }

  static Stream<Arguments> provideNameList(){
    return Stream.of(Arguments.arguments(Arrays.asList("test1", "test2","test3","test4","test5","test6","test7","test8","test9")));
  }

  static Stream<Arguments> provideWrongNameList(){
    return Stream.of(Arguments.arguments(Arrays.asList("test1dsfa","shdfljasdfh","akjds;fkajs")));
  }
}

