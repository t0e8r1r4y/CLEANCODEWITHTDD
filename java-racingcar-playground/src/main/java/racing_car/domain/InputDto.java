package racing_car.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDto {

  public static final int CONDITION = 0;
  private final List<String> nameList;
  private final int endCount;

  public InputDto(String name, String endCount) {
    this.nameList = nameValidator(name);
    this.endCount = endCountValidator(endCount);
  }

  private List<String> nameValidator(String name) {
    if(isImpossible(name)) {
      throw new IllegalArgumentException("이름이 입력되지 않으면 안됩니다.");
    }
    return nameParser(name);
  }

  private boolean isImpossible(String name) {
    return name == null || name.equals("") || name.isEmpty();
  }

  private int endCountValidator(String endCount) {
    if( Integer.parseInt(endCount) <= CONDITION){
      throw new IllegalArgumentException("게임 플레이 횟수는 0 이하의 숫자는 안되용");
    }
    return Integer.parseInt(endCount);
  }

  private List<String> nameParser(String name) {
    String[] nameList = name.split(",");
    List<String> list = Arrays.stream(nameList).collect(Collectors.toList());
    list.forEach(eachName -> eachName.toLowerCase());
    list.forEach(eachName -> eachName.trim());
    return list;
  }

  public static InputDto of(String name, String endCount) {
    return new InputDto(name, endCount);
  }

  public int getEndCount() {
    return this.endCount;
  }

  public List<String> getNameList() {
    return this.nameList;
  }
}
