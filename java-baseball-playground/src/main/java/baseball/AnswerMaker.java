package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class AnswerMaker {

  public static final int MAX_CNT = 3;

  public static String AnswerMaker(){
    Random random = new Random();
    Set<Integer> num = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    while(num.size() < MAX_CNT){
     num.add(random.nextInt(9) + 1);
    }

    Iterator<Integer> iter = num.iterator();
    while(iter.hasNext()){
      int next = iter.next();
      sb.append(next);
    }

    System.out.println("게임 생성시 답은 미리 알고 시작할게용 ~ !! " +  sb.toString());
    return sb.toString();
  }
}
