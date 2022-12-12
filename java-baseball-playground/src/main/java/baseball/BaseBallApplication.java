package baseball;

import java.util.Scanner;

public class BaseBallApplication {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("숫자 야구 게임을 실행합니다.");
    Game game = new Game(AnswerMaker.AnswerMaker());
    String end = "";

    while(scanner.hasNextLine()){

      System.out.println("숫자를 입력해 주세요.");
      String value = scanner.next();
      if(!UserInput.isValid(value)){
        System.out.println("잘못된 입력입니다.");
        continue;
      }

      String result = game.compareAnswer(value);
      System.out.println(result);

      if(result.equals("3S")) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        game = new Game(AnswerMaker.AnswerMaker());
        end = scanner.next();
      }

      if(end.equals("2")) break;
    }

    System.out.println("숫자 야구 게임을 종료합니다.");
  }
}
