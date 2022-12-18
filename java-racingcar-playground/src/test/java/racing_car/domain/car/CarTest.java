package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Nested;;

/**
 * Car라는 클래스는 CarName 클래스와 CarMoving 클래스가 합쳐져서 만들어진 클래스로
 * CarName 테스트 조건과 CarMoving 클래스가 가진 조건을 모두 만족 할 수 있어야 한다.
 */

@DisplayName("Car Class")
public class CarTest {

  @DisplayName("is instantiated with new Car(String name)")
  @ParameterizedTest(name = "차량 이름 {0}을 가진 Car 정상 생성")
  @CsvSource(value = {"test1", "test2", "test3"})
  void isInstantiatedWithNew(String name) {
    new Car(name);
  }

  @DisplayName("is instantiated with new Car(String name). but it doesn't work because of IllegalArgumentException")
  @ParameterizedTest(name = "차량 이름 {0}을 가진 Car 생성 실패(차량 이름의 길이는 5를 초과할 수 없음)")
  @CsvSource(value = {"test12345", "test213432"})
  void isInstantiatedWithNewButFail(String name){
    Throwable expect = assertThrows(IllegalArgumentException.class, ()-> new CarName(name));
    assertThat(expect.getMessage()).isEqualTo("이름은 5글자를 초과할 수 없습니다.");
  }

  @Nested
  @DisplayName("when new")
  class WhenNew{
    private Car car;
    private String name = "test";

    @BeforeEach
    void setUp(){
      car = new Car(name);
    }

    @DisplayName("차량 이름 조회 테스트")
    @Test
    void 이름_조회(){
      assertThat(car.getName()).isEqualTo(name);
      assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차량 이동 테스트")
    @RepeatedTest(value = 9, name = "{displayName} - {currentRepetition}값이 5이상이면 1칸 전진")
    void 차량_이동(RepetitionInfo repetitionInfo){
      int expect = 0;
      if(repetitionInfo.getCurrentRepetition() > 4) expect = 1;

      car.goForward(repetitionInfo.getCurrentRepetition());
      assertThat(car.getPosition()).isEqualTo(expect);
    }
  }
}
