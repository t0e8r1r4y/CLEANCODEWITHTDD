package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("선 계산기 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineCalculatorTest {

  @DisplayName("인스턴스 생성 테스트")
  @Test
  void 인스턴스_생성_성공_테스트(){
    new LineCalculator();
  }

  @DisplayName("인스턴스 생성 후 테스트")
  @Nested
  static class WhenNew{

    private LineCalculator lineCalculator = null;

    @BeforeEach
    void setUp(){
      lineCalculator = new LineCalculator();
    }

    @DisplayName("좌표 목록으로 두 좌표 사이의 길이 계산")
    @ParameterizedTest(name = "좌표 목록 {0}이 주어졌을 때, {1}의 결과를 리턴함")
    @MethodSource("twoCoordinationProvider")
    void 두_좌표_사이의_길이_계산(Coordinations coordinationsInput, int expectLength){
      // when
      double result = lineCalculator.calLength(coordinationsInput);
      // then
      assertThat(Math.floor(result)).isEqualTo(expectLength);
    }

    private static Stream<Arguments> twoCoordinationProvider(){
      Coordinations coordinations = new Coordinations();
      coordinations.add(new Coordination(10,10));
      coordinations.add(new Coordination(14,15));
      return Stream.of(arguments(
          coordinations,  6
      ));
    }


  }

}
