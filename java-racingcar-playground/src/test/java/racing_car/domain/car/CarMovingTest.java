package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;


@DisplayName("CarMoving Class")
public class CarMovingTest {

  @DisplayName("is instantiated with new CarMoving()")
  @Test
  void isInstantiatedWithNew() {
    new CarMoving();
  }

  @Nested
  @DisplayName("when new")
  class WhenNew{
    private CarMoving carMoving;

    @BeforeEach
    void setUp(){
      carMoving = new CarMoving();
    }

    @DisplayName("차량 이동 테스트")
    @RepeatedTest(value = 9, name = "{displayName} - {currentRepetition}값이 5이상이면 1칸 전진")
    void 차량_이동(RepetitionInfo repetitionInfo){
      int expect = 0;
      if(repetitionInfo.getCurrentRepetition() > 4) expect = 1;

      carMoving.goForward(repetitionInfo.getCurrentRepetition());
      assertThat(carMoving.getPosition()).isEqualTo(expect);
    }

  }

}
