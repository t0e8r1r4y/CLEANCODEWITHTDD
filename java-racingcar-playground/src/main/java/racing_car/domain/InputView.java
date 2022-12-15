package racing_car.domain;

import java.util.Scanner;

public class InputView {

  private String names;
  private String endCount;

  private static Scanner scanner = new Scanner(System.in);

  public void setNames(String names) {
    this.names = names;
  }

  public void setEndCount(String endCount) {
    this.endCount = endCount;
  }

  public void printInputMessageForNames(){
    System.out.println("레이싱 카 이름을 입력해주세요.");
    String value = scanner.next();
    setNames(value);
  }

  public void printInputMessageForEndCount(){
    System.out.println("게임 종료 기준을 입력해주세요.");
    String value = scanner.next();
    setEndCount(value);
  }

  public InputDto toDto(){
    return InputDto.of(this.names, this.endCount);
  }
}
