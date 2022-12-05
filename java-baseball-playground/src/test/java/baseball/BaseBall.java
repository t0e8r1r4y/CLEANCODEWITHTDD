package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBall {

  private Ball computerBall;

  @BeforeEach
  void setUp(){
    computerBall = new Ball(1, 4);
  }

  @Test
  @DisplayName("낫싱_판별")
  void 낫싱_판별(){
    assertThat(computerBall.play(new Ball(2,5))).isEqualTo(BallStatus.NOTHING);
  }


  @Test
  @DisplayName("볼_판별")
  void 볼_판별(){
    assertThat(computerBall.play(new Ball(2,4))).isEqualTo(BallStatus.BALL);
  }

  @Test
  @DisplayName("스트라이크_판별")
  void 스트라이크_판별(){
    assertThat(computerBall.play(new Ball(1,4))).isEqualTo(BallStatus.STRIKE);
  }

}
