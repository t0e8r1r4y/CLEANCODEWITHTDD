package racing_car.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandUtil {

  public static final int RANGE = 9;
  private final int number;

  private Random random;

  public RandUtil(int number) {
    this.random = new Random();
    this.number = number;
  }

  public List<Integer> getList() {
    List<Integer> numberList = new ArrayList<>();
    for(int i = 0; i < number; i++){
      numberList.add(random.nextInt(RANGE)+1);
    }
    return numberList;
  }
}
