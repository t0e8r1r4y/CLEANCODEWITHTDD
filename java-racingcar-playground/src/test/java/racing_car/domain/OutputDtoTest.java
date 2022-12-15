package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputDtoTest {

  @DisplayName("Dto 생성")
  @ParameterizedTest
  @MethodSource("provideResult")
  void 생성( Map<String, Integer> result, int expectSize ){
    OutputDto outputDto = new OutputDto(result);

    assertThat(outputDto.getNumberOfCar()).isEqualTo(expectSize);
  }

  static Stream<Arguments> provideResult(){
    Map<String, Integer> result = new HashMap<>();
    result.put("test", 3);
    result.put("test2", 7);
    result.put("test4", 1);

    return Stream.of(Arguments.arguments(
      result, 3
    ));
  }
}
