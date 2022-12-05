package baseball;

public class Ball {

  private final int index;
  private final int number;

  public Ball(int index, int number) {
    this.index = index;
    this.number = number;
  }

  // 볼은 숫자는 같은데 index는 다름
  // 스트라이크는 숫자와 인덱스가 모두 같음
  // 낫싱은 숫자와 인덱스가 모두 다르다.

  public BallStatus play(Ball ball) {
    if(this.matchBallNumber(ball.number) && this.matchIndex(ball.index)) return BallStatus.STRIKE;
    if(this.matchBallNumber(ball.number) && !this.matchIndex(ball.index)) return BallStatus.BALL;
    return BallStatus.NOTHING;
  }

  private boolean matchIndex(int index) {
    return this.index == index;
  }


  private boolean matchBallNumber(int number) {
    return this.number == number;
  }
}
