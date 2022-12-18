package racing_car.domain.game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racing_car.domain.car.Cars;
import racing_car.util.RandUtil;
import racing_car.view.dto.InputDto;

public class Game {

  private final Cars cars;
  private final RandUtil randUtil;
  private final int endCount;

  public Game(InputDto dto){
    this.cars = new Cars(dto.getNameList());
    this.endCount = dto.getEndCount();
    this.randUtil = new RandUtil(dto.getNameList().size());
  }
  public Game(List<String> nameList, int endCount) {
    this.cars = new Cars(nameList);
    this.endCount = endCount;
    this.randUtil = new RandUtil(nameList.size());
  }

  public int getNumberOfCar() {
    return this.cars.getNumberOfCar();
  }

  public int getEndCount() {
    return this.endCount;
  }

  public Map<String, Integer> play() {
    while(!cars.goals(this.endCount)){
      cars.play(randUtil.getList());
    }

    Map<String, Integer> racingResult = this.cars.getCarList()
        .stream()
        .collect(Collectors.toMap(
           k -> k.getName(),
           k -> k.getPosition()
        ));

    return racingResult;
  }
}
