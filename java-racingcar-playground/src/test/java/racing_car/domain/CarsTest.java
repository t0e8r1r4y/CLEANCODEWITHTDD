package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarsTest {

  @DisplayName("차량 목록 생성")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 차량_목록_생성(List<String> nameList, int carListSize){
    Cars cars = new Cars(nameList);
    assertThat(cars.getNumberOfCar()).isEqualTo(carListSize);
  }

  @DisplayName("차량 목록 생성 살패")
  @ParameterizedTest
  @MethodSource("provideWrongNameList")
  void 차량_목록_생성_실패(List<String> nameList){
    assertThrows( IllegalArgumentException.class, ()-> new Cars(nameList));
  }

  @DisplayName("게임 플레이")
  @ParameterizedTest
  @MethodSource("providePlayList")
  void play(List<String> nameList, List<Integer> numList) {
    Cars cars = new Cars(nameList);
    cars.play(numList);

    for(int i = 0; i < cars.getNumberOfCar(); i++){
      if( i < 4) {
        assertThat(cars.getCarList().get(i).getPosition()).isEqualTo(0);
      } else {
        assertThat(cars.getCarList().get(i).getPosition()).isEqualTo(1);
      }
    }
  }

  @DisplayName("게임 종료 여부 판단")
  @ParameterizedTest
  @MethodSource("providePlayList")
  void goals(List<String> nameList, List<Integer> numList) {
    int givenEndCount = 1;
    Cars cars = new Cars(nameList);
    cars.play(numList);
    assertThat(cars.goals(givenEndCount)).isTrue();
  }

  static Stream<Arguments> provideNameList(){
    return Stream.of(Arguments.arguments(Arrays.asList("test1", "test2", "tea"), 3));
  }

  static Stream<Arguments> provideWrongNameList(){
    return Stream.of(Arguments.arguments(Arrays.asList("test1dsfa","shdfljasdfh","akjds;fkajs")));
  }

  static Stream<Arguments> providePlayList(){
    return Stream.of(Arguments.arguments( Arrays.asList("test1", "test2","test3","test4","test5","test6","test7","test8","test9"),
        Arrays.asList(1,2,3,4,5,6,7,8,9)));
  }
}
