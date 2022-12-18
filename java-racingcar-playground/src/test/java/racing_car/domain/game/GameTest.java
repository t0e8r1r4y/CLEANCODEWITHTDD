package racing_car.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing_car.view.dto.InputDto;

@DisplayName("GameTestInfo Demo")
@TestInstance(Lifecycle.PER_CLASS)
public class GameTest {

  private Game game = null;

  @DisplayName("is instantiated with new Game{0}")
  @ParameterizedTest
  @MethodSource("providerForInstantiationTest")
  void isInstantiatedWithNew(InputDto inputDto) {
    new Game(inputDto);
    new Game(inputDto.getNameList(), inputDto.getEndCount());
  }


  @Nested
  @DisplayName("when new")
  class WhenNew{

    @BeforeEach
    void createNewGame() {
      InputDto inputDto = new InputDto("test,test2,test3", "3");
      game = new Game(inputDto);
    }

    @Test
    @DisplayName("게임 생성 후 게임에 포함된 레이싱카 수 확인")
    void 게임에_포함된_차량수_확인(){
      assertThat(game.getNumberOfCar()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 생성 후 게임 종료 조건 확인")
    void 게임_종료_조건_확인(){
      assertThat(game.getEndCount()).isEqualTo(3);
    }


//    static Stream<Arguments> provideNameList(){
//      return Stream.of(Arguments.arguments(InputDto.of("test,test2,test3", "3")));
//    }
  }

/*  @DisplayName("게임 생성")
  @ParameterizedTest
  @MethodSource("provideNameList")
  @Order(1)
  void 게임_생성(InputDto input){
    Game game = new Game(input.getNameList(), input.getEndCount());
    assertThat(game.getNumberOfCar()).isEqualTo(3);
  }

  @DisplayName("게임 종료 조건 확인")
  @ParameterizedTest
  @MethodSource("provideNameList")
  @Order(2)
  void 게임_종료_조건_확인(InputDto input){
    Game game = new Game(input.getNameList(), input.getEndCount());
    assertThat(game.getEndCount()).isEqualTo(3);
  }

  @DisplayName("게임 플레이")
  @ParameterizedTest
  @MethodSource("provideNameList")
  @Order(3)
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
  @Order(4)
  void 게임_결과_반환(InputDto input){
    // given
    Game game = new Game(input.getNameList(), input.getEndCount());
    Map<String, Integer> result = game.play();
    // then
    assertThat(game.getNumberOfCar()).isEqualTo(result.size());
  }*/

  static Stream<Arguments> providerForInstantiationTest(){
    return Stream.of(Arguments.arguments(InputDto.of("test,test2,test3", "3")));
  }

}
