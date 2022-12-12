package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsTest {
  Balls balls;

  @BeforeEach
  void setUp(){
    balls = new Balls("123");
  }

  @Test
  void 세개숫자생성테스트(){
    assertThat(balls.getBalls().get(0).getNumber()).isEqualTo(1);
    assertThat(balls.getBalls().get(1).getNumber()).isEqualTo(2);
    assertThat(balls.getBalls().get(2).getNumber()).isEqualTo(3);
    assertThat(balls.getBalls().get(0).getPosition()).isEqualTo(1);
    assertThat(balls.getBalls().get(1).getPosition()).isEqualTo(2);
    assertThat(balls.getBalls().get(2).getPosition()).isEqualTo(3);
  }

  @Test
  void 숫자비교테스트_낫싱(){
    Balls givenBalls = new Balls("456");
    String result = balls.play(givenBalls);
    assertThat(result).isEqualTo("NOTHING");
  }

  @Test
  void 숫자비교테스트_쓰리_볼(){
    Balls givenBalls = new Balls("312");
    String result = balls.play(givenBalls);
    assertThat(result).isEqualTo("3B");
  }

  @Test
  void 숫자비교테스트_쓰리_스트라이크(){
    Balls givenBalls = new Balls("123");
    String result = balls.play(givenBalls);
    assertThat(result).isEqualTo("3S");
  }

  @ParameterizedTest(name = "{index} {displayName} message={0}")
  @CsvSource({"123,3S", "312,3B", "143,2S", "321, 1S2B", "124, 2S", "789, NOTHING", "567, NOTHING"})
  void 숫자비교테스트(String given, String answer){
    Balls givenBalls = new Balls(given);
    String result = balls.play(givenBalls);
    assertThat(result).isEqualTo(answer);
  }
}
