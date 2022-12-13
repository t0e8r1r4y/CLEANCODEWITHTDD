package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.domain.Car;

public class CarTest {

  @Test
  @DisplayName("차량 생성")
  void 경주차_생성(){
    Car car = new Car("fifa");
    assertThat(car.getCarName().getName()).isEqualTo("fifa");
    assertThat(car.getMoving().getMovingForwardcnt()).isEqualTo(0);
  }

  @Test
  @DisplayName("차량 생성 실패")
  void 경주차_생성_잘못된_이름으로(){
    assertThatThrownBy(()-> new Car("testestsetse"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("차량 전진")
  void 경주차량_전진(){
    Car car = new Car("fifa");
    car.getMoving().forward(9);
    assertThat(car.getMoving().getMovingForwardcnt()).isEqualTo(1);
  }

}
