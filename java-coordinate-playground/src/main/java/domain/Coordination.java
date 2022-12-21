package domain;

public class Coordination {

  public static final int MIN_VALUE = 0;
  public static final int MAX_VALUE = 24;
  private final int x;
  private final int y;

  public Coordination(int x, int y) {
    positionValidate(x,y);
    this.x = x;
    this.y = y;
  }

  private void positionValidate(int x, int y) {
    if(isPossible(x, y)) throw new IllegalArgumentException("좌표의 x, y는 0이상 24 이하입니다.");
  }

  private boolean isPossible(int x, int y) {
    return x < MIN_VALUE || x > MAX_VALUE || y < MIN_VALUE || y > MAX_VALUE;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
