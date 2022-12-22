package domain;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TriangleCalculator {

  public double calcArea(Coordination pos1, Coordination pos2, Coordination pos3) {
    double t1 = (pos1.getX() * pos2.getY()) + (pos2.getX() * pos3.getY()) + (pos3.getX() * pos1.getY());
    double t2 = (pos1.getY() * pos2.getX()) + (pos2.getY() * pos3.getX()) + (pos3.getY() * pos1.getX());
    return (0.5) * (abs( t1 - t2 ));
  }

  private double calLength(Coordination inputPos1, Coordination inputPos2) {
    double xLen = abs(inputPos1.getX() - inputPos2.getX());
    double yLen = abs(inputPos1.getY() - inputPos2.getY());
    return sqrt(pow(xLen,2) + pow(yLen, 2));
  }
}
