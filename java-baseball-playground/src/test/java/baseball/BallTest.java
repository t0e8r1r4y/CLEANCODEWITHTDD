package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

  Ball ball;

  @BeforeEach
  void setup(){
    ball = new Ball(1, 3);
  }

  @Test
  @DisplayName("Ball 생성 테스트")
  void 숫자생성테스트(){
    assertThat(ball.getPosition()).isEqualTo(1);
    assertThat(ball.getNumber()).isEqualTo(3);
  }


  @Test
  @DisplayName("Ball 판별 테스트")
  void 두개의_볼이_주어질때_볼테스트() {
    Ball givenBall = new Ball(2,3);
    assertTrue(ball.isBall(givenBall));
    assertFalse(ball.isStrike(givenBall));
  }

  @Test
  @DisplayName("Stike 판별 테스트")
  void 두개의_볼이_주어질때_스트라이크_테스트() {
    Ball givenBall = new Ball(1,3);
    assertTrue(ball.isStrike(givenBall));
    assertFalse(ball.isBall(givenBall));
  }

  @ParameterizedTest(name = "{index} {displayName} message={0}")
  @CsvSource({"1,3,false", "2,3,true", "3,3,true"})
  void 두개의_볼이_주어질때_볼_테스트(int pos, int num, boolean answer){
    Ball givenBall = new Ball(pos, num);
    assertThat(ball.isBall(givenBall)).isEqualTo(answer);
  }

  @ParameterizedTest(name = "{index} {displayName} message={0}")
  @CsvSource({"1,3,true", "2,3,false", "3,3,false"})
  void 두개의_볼이_주어질때_스트라이크_테스트(int  pos, int num, boolean answer){
    Ball givenBall = new Ball(pos,num);
    assertThat(ball.isStrike(givenBall)).isEqualTo(answer);
  }

}
