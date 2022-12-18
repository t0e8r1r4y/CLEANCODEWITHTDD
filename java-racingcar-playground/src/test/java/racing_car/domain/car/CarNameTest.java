package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("CarName Class")
class CarNameTest {

  @DisplayName("is instantiated with new CarName(String name)")
  @ParameterizedTest(name = "차량 이름 {0}은 정상 생성 가능")
  @CsvSource(value = {"test1", "test2"})
  void isInstantiatedWithNew(String name) {
    new CarName(name);
  }

  @DisplayName("is instantiated with new CarName(String name). but it doesn't work because of IllegalArgumentException")
  @ParameterizedTest(name = "차량 이름 {0}은 정상 생성 실패(차량 이름의 길이는 5를 초과할 수 없음)")
  @CsvSource(value = {"test12345", "test213432"})
  void isInstantiatedWithNewButFail(String name){
    Throwable expect = assertThrows(IllegalArgumentException.class, ()-> new CarName(name));
    assertThat(expect.getMessage()).isEqualTo("이름은 5글자를 초과할 수 없습니다.");
  }

  @Nested
  @DisplayName("when new")
  class WhenNew{

    private CarName carName;
    private String name = "test1";

    @BeforeEach
    void setUp(){
      carName = new CarName(name);
    }

    @Test
    @DisplayName("차량 이름 조회 테스트")
    void 이름_조회(){
      assertThat(carName.getName()).isEqualTo(name);
    }

  }

}