package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CarMovingTest {

  private CarMoving carMoving;

  @BeforeEach
  void setUp(){
    carMoving = new CarMoving();
  }

  @DisplayName("차량 이동 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,0", "9,1"})
  void 차량_이동(int given, int expected){
    carMoving.goForward(given);
    assertThat(carMoving.getPosition()).isEqualTo(expected);
  }

}
