package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputDtoTest {

  @DisplayName("입력 dto 생성")
  @Test
  void 생성(){
    String givenName = "test,test2,test3";
    List<String> namList = Arrays.asList("test","test2","test3");
    String givenEndCount = "5";
    int expectEndCount = 5;

    InputDto dto = InputDto.of( givenName, givenEndCount );

    assertThat(dto.getEndCount()).isEqualTo(expectEndCount);
    assertThat(dto.getNameList()).isEqualTo(namList);
  }

  @DisplayName("입력 dto 생성 실패")
  @ParameterizedTest
  @CsvSource(value = {",3", "'',3"})
  void 생성_실패(String givenName, int givenEndCount){
    assertThrows(IllegalArgumentException.class, ()-> InputDto.of( givenName,
        String.valueOf(givenEndCount)));
  }

  @DisplayName("입력 dto 생성 실패 - 테스트 메시지 확인")
  @ParameterizedTest
  @CsvSource(value = {",3", "'',3"})
  void 생성_실패_메시지(String givenName, int givenEndCount){
    Throwable expect = assertThrows(IllegalArgumentException.class, ()-> InputDto.of( givenName,
        String.valueOf(givenEndCount)));
    assertThat(expect.getMessage()).isEqualTo("이름이 입력되지 않으면 안됩니다.");
  }

}
