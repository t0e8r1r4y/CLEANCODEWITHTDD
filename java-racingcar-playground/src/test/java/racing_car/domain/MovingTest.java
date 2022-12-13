package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.domain.Moving;

public class MovingTest {

  Moving moving;

  @BeforeEach
  void setUp(){
    moving = new Moving();
  }

  @Test
  @DisplayName("전진 테스트")
  void 전진(){
    moving.forward(4);
    int movingForwardCnt = moving.getMovingForwardcnt();
    assertThat(movingForwardCnt).isEqualTo(1);
  }

  @Test
  @DisplayName("전진 못함")
  void 제자리(){
    moving.forward(3);
    int movingForwardCnt = moving.getMovingForwardcnt();
    assertThat(movingForwardCnt).isEqualTo(0);
  }

}
