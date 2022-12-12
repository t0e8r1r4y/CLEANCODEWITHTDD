package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerMakerTest {

  @Test
  @DisplayName("정답 생성 시 제대로 생성되는지 테스트")
  void answerMaker() {
    for(int i = 0; i < 1000000; i++){
      Boolean result = UserInput.isValid(AnswerMaker.AnswerMaker());
      assertThat(result).isEqualTo(true);
    }
  }
}