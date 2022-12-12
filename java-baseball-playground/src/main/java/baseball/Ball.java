package baseball;

public class Ball {

  private int position;
  private int number;

  public Ball(int position, int number) {
    this.position = position;
    this.number = number;
  }

  public int getPosition() {
    return position;
  }

  public int getNumber() {
    return number;
  }

  public boolean isBall(Ball ball){
    return ((this.position != ball.getPosition()) && (this.number == ball.getNumber()));
  }

  public boolean isStrike(Ball ball){
    return ((this.position == ball.getPosition()) && (this.number == ball.getNumber()));
  }
}
