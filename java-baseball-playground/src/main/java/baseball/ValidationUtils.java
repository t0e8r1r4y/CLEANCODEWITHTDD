package baseball;

public class ValidationUtils {

  public static final int MAX_NUM = 9;
  public static final int MIN_NUM = 1;

  private ValidationUtils(){
    throw new IllegalArgumentException();
  }

  public static boolean validationNumber(int number) {
    return (number <= MAX_NUM && number >= MIN_NUM); // ctr + alt + c -> static final 만드는 단축키
  }
}
