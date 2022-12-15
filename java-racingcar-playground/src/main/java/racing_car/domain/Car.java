package racing_car.domain;

public class Car {

  private final CarName carName;
  private CarMoving carMoving;

  public Car(String name) {
    this.carName = new CarName(name);
    this.carMoving = new CarMoving();
  }

  public String getName() {
    return carName.getName();
  }

  public int getPosition() {
    return carMoving.getPosition();
  }

  public int goForward(int number) {
    carMoving.goForward(number);
    return carMoving.getPosition();
  }
}
