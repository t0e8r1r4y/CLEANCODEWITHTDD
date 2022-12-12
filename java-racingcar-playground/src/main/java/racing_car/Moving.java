package racing_car;

public class Moving {

  private int movingForwardcnt;

  public int getMovingForwardcnt() {
    return movingForwardcnt;
  }
  public void forward(int num) {
    if(num >= 4) movingForwardcnt++;
  }
}
