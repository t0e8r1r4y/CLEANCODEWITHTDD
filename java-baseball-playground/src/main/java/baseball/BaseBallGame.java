package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.logging.Logger;

@Logger
public class BaseBallGame {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    BaseBallNum computer = new BaseBallNum();;
    boolean endGame = false;

    computer.showNumber();

    while(scanner.hasNextLine()){

      if(endGame == true) {
        break;
      }

      System.out.println("숫자를 입력해 주세요.");
      String value = scanner.next();

      // 입력 검증
      if( validate(value) ) {
        System.out.println("입력이 틀렸습니다.");
        continue;
      }

      // 숫자 체크
      String result = computer.check(value);

      // 정답을 맞췄을 경우
      if (result.equals("end")) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        computer.regenNumber();
        computer.showNumber();
        endGame = endGameCheck();
      }

      System.out.println(result);
    }

    System.out.println("게임이 종료되었습니다.");
  }

  private static boolean endGameCheck(){
    while(scanner.hasNextLine()){
      int num = Integer.parseInt(scanner.next());
      if(num == 1) return false;
      if(num == 2) return true;
      System.out.println("입력값이 틀렸습니다. 1또는 2만 입력하시오.");
    }
    return false;
  }

  private static boolean validate(String numbers){
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length(); i++) {
      if(numbers.charAt(i) >= '1' && numbers.charAt(i) <= '9') return false;
      if(map.get(numbers.charAt(i)) != 0) return false;
    }
    return true;
  }

}