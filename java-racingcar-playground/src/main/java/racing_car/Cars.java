package racing_car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
  private List<Car> carList;

  public Cars(List<String> givenList) {
    carList = new ArrayList<>();
    for (String name : givenList){
      carList.add(new Car(name));
    }
  }

  public int getCarsNum() {
    return carList.size();
  }


  public List<Car> getCarList() {
    return carList;
  }

  public void move(List<Integer> numList) {
    for(int i = 0; i < numList.size(); i++){
      carList.get(i).getMoving().forward(numList.get(i));
    }
  }


  public Map<String, Integer> getMovingForwardCntList() {
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < this.carList.size(); i++){
      map.put(carList.get(i).getCarName().getName(),
          carList.get(i).getMoving().getMovingForwardcnt());
    }
    return map;
  }
}
