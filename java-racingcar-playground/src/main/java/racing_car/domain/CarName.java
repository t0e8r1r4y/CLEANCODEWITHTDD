package racing_car.domain;

public class CarName {

  public static final int MAX_NAME_LENGTH = 5;
  private String name;

  public CarName(final String name) {
    carNameValidate(name);
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  private void carNameValidate(String carName) {
    if(carName.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
  }
}
