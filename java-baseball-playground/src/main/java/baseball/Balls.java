package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
  public static final int MAX_BALL_CNT = 3;
  public static final char OFFSET = '0';
  public static final int EMPTY = 0;
  private List<Ball> balls;

  public Balls(String number) {
    this.balls = mapBalls(number);
  }

  private static List<Ball> mapBalls(String number) {
    List<Ball> balls = new ArrayList<>();
    for(int i = 0; i < number.length(); i++){
      balls.add(new Ball(i+1, number.charAt(i) - OFFSET));
    }
    return balls;
  }

  public List<Ball> getBalls() {
    return balls;
  }


  public String play(Balls givenBalls) {
    StringBuilder sb = new StringBuilder();
    boolean checked[] = new boolean[MAX_BALL_CNT];
    int strikeCnt = checkStrike(givenBalls, checked);
    int ballCnt = checkBall(givenBalls, checked);

    if(strikeCnt != 0){
      sb.append(strikeCnt);
      sb.append("S");
    }

    if(ballCnt != 0) {
      sb.append(ballCnt);
      sb.append("B");
    }

    if(sb.length() != EMPTY) return sb.toString();
    return "NOTHING";
  }

  private int checkStrike(Balls givenBalls, boolean checked[]) {
    int strike = 0;
    for (int i = 0; i < MAX_BALL_CNT; i++) {
      if(this.balls.get(i).isStrike(givenBalls.getBalls().get(i))){
        strike++;
        checked[i] = true;
      }
    }
    return strike;
  }

  private int checkBall(Balls givenBalls, boolean checked[]){
    int ball = 0;
    for (int i = 0; i < MAX_BALL_CNT; i++) {
      if(checked[i]) continue;
      ball += getBall(givenBalls, checked, i);
    }
    return ball;
  }

  private int getBall(Balls givenBalls, boolean[] checked, int i) {
    int ball = 0;
    for(int j = 0; j < 3; j++){
      if( i == j ) continue;
      if(this.balls.get(i).isBall(givenBalls.getBalls().get(j))){
        ball++;
        checked[i] = true;
      }
    }
    return ball;
  }

}
