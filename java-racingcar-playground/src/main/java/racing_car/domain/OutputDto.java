package racing_car.domain;

import java.util.Map;

public class OutputDto {

  private final Map<String, Integer> racingResult;

  public OutputDto(Map<String, Integer> result) {
    this.racingResult = result;
  }

  public int getNumberOfCar() {
    return this.racingResult.size();
  }
}
