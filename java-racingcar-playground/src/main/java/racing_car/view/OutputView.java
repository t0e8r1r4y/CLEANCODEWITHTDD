package racing_car.view;

import java.util.Map;

public class OutputView {

  public void printRacingResult( Map<String, Integer> racingResult){
    for(Map.Entry<String,Integer> element : racingResult.entrySet() ){
      printCarResult(element.getKey(), element.getValue());
    }
  }

  private void printCarResult(String key, Integer value) {
    StringBuilder sb = new StringBuilder();
    sb.append(key);
    sb.append(" : ");
    for(int i = 0; i < value; i++){
      sb.append("-");
    }
    System.out.println(sb.toString());
  }
}
