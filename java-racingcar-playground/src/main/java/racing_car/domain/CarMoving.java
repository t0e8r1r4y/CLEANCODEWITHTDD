package racing_car.domain;

public class CarMoving {

  public static final int MOVING_CONDITION = 4;
  private int position;

  public CarMoving() {
    this.position = 0;
  }

  public void goForward(int number) {
    if(number > MOVING_CONDITION) this.position++;
  }

  public int getPosition() {
    return this.position;
  }
}
