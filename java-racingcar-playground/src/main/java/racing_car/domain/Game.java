package racing_car.domain;

import java.util.List;
import java.util.Map;

public class Game {

  private final Cars cars;
  private final int count;

  public Game(List<String> nameList, int count) {
    this.cars = new Cars(nameList);
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public Map<String, Integer> getResult() {
    return this.cars.getMovingForwardCntList();
  }

  public void play() {
  }
}
