package racing_car.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> carList;

  public Cars(List<String> nameList) {
    carList = new ArrayList<>();
    for(String name : nameList) {
      this.carList.add(new Car(name));
    }
  }

  public int getNumberOfCar() {
    return carList.size();
  }

  public List<Car> getCarList() {
    return carList;
  }

  public void play(List<Integer> list) {
    for(int i = 0; i < list.size(); i++){
      this.carList.get(i).goForward(list.get(i));
    }
  }

  public boolean goals(int endCount) {
    for(int i = 0; i < carList.size(); i++) {
      if(carList.get(i).getPosition() == endCount) return true;
    }
    return false;
  }
}
