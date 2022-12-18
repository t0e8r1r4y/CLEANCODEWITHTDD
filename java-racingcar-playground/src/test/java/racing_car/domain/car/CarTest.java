package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.domain.car.Car;

public class CarTest {

  @DisplayName("차량 생성 테스트")
  @ParameterizedTest
  @CsvSource(value = {"test1, test2, test3"})
  void 차량_생성(String name){
    Car car = new Car(name);
    assertThat(car.getName()).isEqualTo(name);
    assertThat(car.getPosition()).isEqualTo(0);
  }


  @DisplayName("차량 생성 실패 테스트")
  @Test
  void 차량_생성_실패(){
    String given = "test1234";
    assertThrows(IllegalArgumentException.class,() -> new Car(given));
  }

  @DisplayName("차량 생성 실패 테스트 - 에러 메시지 확인")
  @Test
  void 차량_생성_실패_에러메시지_확인(){
    String given = "test1234";
    Throwable expect =  assertThrows(IllegalArgumentException.class,() -> new Car(given));
    assertThat(expect.getMessage()).isEqualTo("차량 이름은 5글자를 초과할 수 없습니다.");
  }

  @DisplayName("차량 동작테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,0","2,0","3,0","4,0","5,1","6,1","7,1","8,1","9,1"})
  void 차량_이동(int number, int expect){
    String givenCarName = "test";
    Car car = new Car(givenCarName);
    assertThat(car.goForward(number)).isEqualTo(expect);
  }

}
