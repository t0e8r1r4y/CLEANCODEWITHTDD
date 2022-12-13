package racing_car.domain;

public class Moving {

  private int movingForwardcnt;

  public int getMovingForwardcnt() {
    return movingForwardcnt;
  }
  public void forward(int num) {
    if(num >= 4) movingForwardcnt++;
  }
}
