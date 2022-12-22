package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

@DisplayName("삼각형 면적 계산기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TriangleCalculatorTest {

  @DisplayName("인스턴스 생성 테스트")
  @Test
  void 인스턴스_생성_성공_테스트() { new TriangleCalculator(); }

  @DisplayName("인스턴스 생성 후 테스트")
  @Nested
  static class WhenNew{
    private TriangleCalculator triangleCalculator = null;

    @BeforeEach
    void setUp() {
      triangleCalculator = new TriangleCalculator();
    }

    @DisplayName("삼각형 넓이 계산")
    @ParameterizedTest(name = "좌표{0},{1},{2}이 주어졌을 때, {3}의 결과를 리턴함")
    @MethodSource("threeCoordinationProvider")
    void  삼각형_면적_계산(Coordination pos1, Coordination pos2, Coordination pos3, int expected){
      double result = triangleCalculator.calcArea(pos1, pos2, pos3);

      assertThat(Math.floor(result)).isEqualTo(expected);
    }

    @DisplayName("삼각형 넓이 계산 실패")
    @ParameterizedTest(name = "좌표{0},{1},null이 주어졌을 때, {3}의 결과를 리턴함")
    @MethodSource("threeCoordinationProvider")
    void  삼각형_면적_계산_실패(Coordination pos1, Coordination pos2, Coordination pos3, int expected){
      assertThrows(NullPointerException.class, () -> triangleCalculator.calcArea(pos1, null, pos3));
    }

    private static Stream<Arguments> threeCoordinationProvider() {
      return Stream.of(arguments(
          new Coordination(10,10),
          new Coordination(14,15),
          new Coordination(20,8),
          29
      ));
    }
  }

}
