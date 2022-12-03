package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumTest {

  @Test
  @DisplayName("입력 받은 숫자와 생성한 숫자를 확인합니다.")
  void check() {
    BaseBallNum given = new BaseBallNum();
    given.showNumber();

  }
}