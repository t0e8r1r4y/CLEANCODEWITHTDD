package racing_car.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

  private List<String> nameList;
  private int count;

  public void takeNames(String value) {
    value.trim();
    if(!isValid(value)) throw new IllegalArgumentException("잘못된 입력입니다.");

    String[] names = value.split(",");
    this.nameList = Arrays.stream(names).collect(Collectors.toList());
  }

  private boolean isValid(String value) {
    if(value.isEmpty()) return false;
    return true;
  }

  public List<String> getNames() {
    return nameList;
  }

  public void takeForwardCount(int count) {
    this.count = count;
  }

  public int getForwardCount() {
    return count;
  }

  public void printNameInputMessage(){
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
  }

  public void printCountInputMessage(){
    System.out.println("시도할 회수는 몇회인가요?");
  }
}
