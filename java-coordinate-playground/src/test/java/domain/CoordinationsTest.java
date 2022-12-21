package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
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

@DisplayName("좌표 목록 생성 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CoordinationsTest {

  @DisplayName("인스턴스 생성 테스트 - 정상 입력 범위에서 생성 성공")
  @Test
  void 인스턴스_생성_성공_테스트(){
    new Coordinations();
  }

  @DisplayName("인스턴스 생성 후 테스트")
  @Nested
  static class WhenNew{

    private Coordinations coordinations = null;

    @BeforeEach
    void setUp(){
      coordinations = new Coordinations();
    }

    @DisplayName("좌표 입력 테스트")
    @ParameterizedTest(name = "좌표 객체 {0} 한개 입력 - 좌표 목록의 크기는 {2}이며 추가 결과는 {1}")
    @MethodSource("oneCoordinationProvider")
    void 좌표_입력_테스트(Coordination input, boolean expectResult, int expectSize){
      // given -> Before Setup
      // when
      boolean result = coordinations.add(input);
      // then
      assertThat(result).isEqualTo(expectResult);
      assertThat(coordinations.size()).isEqualTo(expectSize);
    }

    @DisplayName("좌표 입력 테스트2")
    @ParameterizedTest(name = "좌표 객체 {0}을 각각 입력 시, {1}의 추가결과와 좌표 목록의 크기 {2}가 기대 됨")
    @MethodSource("threeCoordinationProvider")
    void 좌표_세개_입력_테스트(List<Coordination> input, List<Boolean> expectResult,
        List<Integer> expectSize){

      int idx = 0;
      for (Coordination coordination : input) {
        boolean result =  coordinations.add(coordination);
        assertThat(result).isEqualTo(expectResult.get(idx));
        assertThat(coordinations.size()).isEqualTo(expectSize.get(idx++));
      }

    }

    @DisplayName("좌표 입력 테스트3")
    @ParameterizedTest(name = "좌표 객체 {0}을 각각 입력 시, {1}의 추가결과와 좌표 목록의 크기 {2}가 기대 됨")
    @MethodSource("fiveCoordinationProvider")
    void 좌표_다섯개_입력_테스트(List<Coordination> input, List<Boolean> expectResult,
        List<Integer> expectSize){

      int idx = 0;
      for (Coordination coordination : input) {
        boolean result =  coordinations.add(coordination);
        assertThat(result).isEqualTo(expectResult.get(idx));
        assertThat(coordinations.size()).isEqualTo(expectSize.get(idx++));
      }

    }

    @DisplayName("좌표 조회 테스트")
    @ParameterizedTest(name = "하나의 입력 {0}을 추가 후, 해당 인덱스를 조회하면 동일한 객체가 조회됨")
    @MethodSource("oneCoordinationProvider")
    void 좌표_목록_조회_테스트(Coordination input){
      // given
      coordinations.add(input);
      // when
      Coordination coordination = coordinations.get(0);
      // then
      assertThat(coordination.getX()).isEqualTo(10);
      assertThat(coordination.getY()).isEqualTo(10);
      assertThat(coordination).isEqualTo(input);
    }

    @DisplayName("좌표 조회 테스트2")
    @ParameterizedTest(name = "하나의 입력 {0}을 추가 후, 더 큰 인덱스의 값을 요청하면 실패")
    @MethodSource("oneCoordinationProvider")
    void 좌표_목록_조회_테스트_실패(Coordination input){
      // given
      coordinations.add(input);
      // when
      assertThrows(IllegalArgumentException.class, ()-> coordinations.get(3));
    }

    @DisplayName("좌표 전체 목록 조회 테스트")
    @ParameterizedTest(name = "{0} 입력과 전체 조회 결과가 동일합니다.")
    @MethodSource("threeCoordinationProvider")
    void 좌표_목록_전체_조회_테스트(List<Coordination> input){
      // given
      for (Coordination coordination : input) {
        coordinations.add(coordination);
      }
      // when
      List<Coordination> expectedList = coordinations.getAll();
      //then
      assertThat(expectedList).isEqualTo(input);
    }

    private static Stream<Arguments> oneCoordinationProvider(){
      return Stream.of(arguments( new Coordination(10, 10), true, 1));
    }

    private static Stream<Arguments> threeCoordinationProvider(){
      return Stream.of(arguments(
          Arrays.asList(new Coordination(1,2), new Coordination(3,4), new Coordination(10,10)),
          Arrays.asList(true, true, true),
          Arrays.asList(1,2,3)
      ));
    }

    private static Stream<Arguments> fiveCoordinationProvider(){
      return Stream.of(arguments(
          Arrays.asList(new Coordination(1,2), new Coordination(3,4),
              new Coordination(10,10), new Coordination(20,20), new Coordination(18,18)),
          Arrays.asList(true, true, true,true, false),
          Arrays.asList(1,2,3,4,4)
      ));
    }

  }

}
