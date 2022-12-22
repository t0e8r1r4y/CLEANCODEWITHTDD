package domain;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class LineCalculator {

  public static final int FIRST_IDX = 0;
  public static final int SECOND_IDX = 1;

  public double calLength(Coordinations coordinations) {
    Coordination pos1 = coordinations.get(FIRST_IDX);
    Coordination pos2 = coordinations.get(SECOND_IDX);
    double xLen = abs(pos1.getX() - pos2.getX());
    double yLen = abs(pos1.getY() - pos2.getY());
    return sqrt(pow(xLen,2) + pow(yLen, 2));
  }
}
