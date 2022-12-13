package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.domain.CarName;

public class CarTestNameTest {

  @Test
  @DisplayName("차량 이름 붙이기")
  void 차량이름짓기(){
    CarName carName = new CarName("carin");
    assertThat(carName.getName()).isEqualTo("carin");
  }

  @Test
  @DisplayName("차량 이름이 5자 이상인 경우 이름 생성에 실패한다.")
  void 틀린차량이름짓기(){
    String given = "testsetest";
    assertThatThrownBy(()-> new CarName(given)).isInstanceOf(IllegalArgumentException.class);
  }

}
