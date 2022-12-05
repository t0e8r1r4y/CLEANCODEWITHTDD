package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 현재 코드의 문제점은 하나에 모든 것을 구현하면서 코드 복잡도가 증가하였다.
 * 이 부분을 어떻게 하면 더 쪼갤 수 있을지 고민을 해야한다.
 * 전체 숫자를 다 비교하는 것보다는 주어진 하나를 가지고 스트라이크, 볼, 낫싱을 판단한다.
 */
public class BaseBallNum {
  private final static int MAX_NUM = 3; // 최대 3개의 숫자를 뽑는다.
  private List<Integer> list;

  public BaseBallNum() {
    this.list = initNumber();
  }

  public void regenNumber(){
    this.list.clear();
    this.list = initNumber();
  }

  public void showNumber(){
    System.out.println(list);
  }

  public String check(String number){
    List<Integer> input = chageList(number);

    int strike = 0;
    int ball = 0;

    for (int i = 0; i < input.size(); i++) {
      if(strikeCheck(input.get(i), i)){
        strike++;
        continue;
      }

      if(ballScheck(input.get(i),i)) {
        ball++;
      }
    }

    return makeResult(strike,ball);
  }

  private String makeResult(int strike, int ball){
    StringBuilder sb = new StringBuilder();
    if(strike == 0 && ball == 0) return "낫싱";
    if(strike == 3) return "end";

    if(ball != 0){
      sb.append(ball);
      sb.append("볼 ");
    }

    if(strike != 0){
      sb.append(strike);
      sb.append("스트라이크");
    }
    return sb.toString();
  }

  private boolean strikeCheck(int num, int index) {
    return list.get(index) == num;
  }

  private boolean ballScheck(int num, int index){
    return list.get(index) != num && list.contains(num);
  }

  private List<Integer> chageList(String number){
    List<Integer> inputList = new ArrayList<>();
    for (int i = 0; i < number.length(); i++) {
      inputList.add( (number.charAt(i) - '0') );
    }
    return inputList;
  }

  private List<Integer> initNumber() {
    List<Integer> number = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < MAX_NUM; i++) {
      int num = random.nextInt(9) + 1;

      if (number.contains(num)) {
        i--;
        continue;
      }
      number.add(num);
    }
    return number;
  }

}
