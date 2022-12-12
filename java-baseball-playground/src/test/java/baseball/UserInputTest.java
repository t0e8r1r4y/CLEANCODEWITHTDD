package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {

  @Test
  @DisplayName("사용자 입력 검증")
  void 정상입력(){
    String given = "123";
    boolean result = UserInput.isValid(given);
    assertTrue(result);
  }

  @Test
  @DisplayName("사용자 입력 검증 실패 - 길이가 초과함")
  void 비정상입력(){
    String given = "1234";
    boolean result = UserInput.isValid(given);
    assertFalse(result);
  }

  @Test
  @DisplayName("사용자 입력 검증 실패 - 중복값 존재")
  void 비정상입력2(){
    String given = "112";
    boolean result = UserInput.isValid(given);
    assertFalse(result);
  }

  @Test
  @DisplayName("사용자 입력 검증 실패 - 범위에 없는 값")
  void 비정상입력3(){
    String given = "000";
    boolean result = UserInput.isValid(given);
    assertFalse(result);
  }
}
