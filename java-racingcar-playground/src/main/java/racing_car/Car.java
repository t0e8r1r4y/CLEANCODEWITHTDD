package racing_car;

public class Car {

  private final CarName carName;
  private Moving mooving;

  public Car(String name) {
    this.carName = new CarName(name);
    this.mooving = new Moving();
  }

  public CarName getCarName() {
    return carName;
  }

  public Moving getMoving() {
    return mooving;
  }
}
