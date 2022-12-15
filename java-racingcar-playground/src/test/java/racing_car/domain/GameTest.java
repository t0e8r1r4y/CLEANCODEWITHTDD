package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

  @DisplayName("게임 생성")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 게임_생성(InputDto input){
    Game game = new Game(input.getNameList(), input.getEndCount());
    assertThat(game.getNumberOfCar()).isEqualTo(3);
  }

  @DisplayName("게임 종료 조건 확인")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 게임_종료_조건_확인(InputDto input){
    Game game = new Game(input.getNameList(), input.getEndCount());
    assertThat(game.getEndCount()).isEqualTo(3);
  }

  @DisplayName("게임 플레이")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 게임_플레이(InputDto input){
    // given
    int given = 0;
    Game game = new Game(input.getNameList(), input.getEndCount());
    // when
    Map<String, Integer> result = game.play();
    for(Map.Entry<String, Integer> element : result.entrySet()){
      if(element.getValue() == input.getEndCount()) given++;
    }
    // then
    assertThat(given).isGreaterThan(0);
  }

  @DisplayName("게임 플레이 결과 반환")
  @ParameterizedTest
  @MethodSource("provideNameList")
  void 게임_결과_반환(InputDto input){
    // given
    Game game = new Game(input.getNameList(), input.getEndCount());
    Map<String, Integer> result = game.play();
    // then
    assertThat(game.getNumberOfCar()).isEqualTo(result.size());
  }

  static Stream<Arguments> provideNameList(){
    return Stream.of(Arguments.arguments(InputDto.of("test,test2,test3", "3")));
  }

}
