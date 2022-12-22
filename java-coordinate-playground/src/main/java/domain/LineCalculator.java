package domain;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class LineCalculator {

  public double calLength(Coordination inputPos1, Coordination inputPos2) {
    double xLen = abs(inputPos1.getX() - inputPos2.getX());
    double yLen = abs(inputPos1.getY() - inputPos2.getY());
    return sqrt(pow(xLen,2) + pow(yLen, 2));
  }

}
