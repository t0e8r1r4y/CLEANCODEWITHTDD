package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserInput {

  public static final int MAX_LEN = 3;
  public static final char OFFSET = '0';
  public static final int MIN_NUM = 1;
  public static final int MAX_NUM = 9;

  public static boolean isValid(String given) {
    if(given.length() > MAX_LEN) return false;
    if(isOverlap(given)) return false;
    if(!isPossibleRange(given)) return false;
    return true;
  }

  private static boolean isPossibleRange(String given) {
    for(int i = 0; i < given.length(); i++) {
      if(given.charAt(i)-OFFSET < MIN_NUM) return false;
      if(given.charAt(i)-OFFSET > MAX_NUM) return false;
    }
    return true;
  }

  private static boolean isOverlap(String given) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < given.length(); i++) {
      set.add(given.charAt(i) - OFFSET);
    }
    if(set.size() == MAX_LEN) return false;
    return true;
  }
}
