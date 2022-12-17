package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

  @DisplayName("차량 이름 생성 테스트")
  @ParameterizedTest(name = "차량 이름 {0}은 정상 생성 가능")
  @CsvSource(value = {"test1", "test2"})
  void 이름_생성(String name){
    CarName carName = new CarName(name);
    assertThat(carName.getName()).isEqualTo(name);
  }

  @DisplayName("차량 이름 생성 실패 테스트")
  @ParameterizedTest(name = "차량 이름 {0}은 정상 생성 실패(차량 이름의 길이는 5를 초과할 수 없음)")
  @CsvSource(value = {"test12345", "test213432"})
  void 이름_생성_실패(String name){
    Throwable expect = assertThrows(IllegalArgumentException.class, ()-> new CarName(name));
    assertThat(expect.getMessage()).isEqualTo("이름은 5글자를 초과할 수 없습니다.");
  }
}