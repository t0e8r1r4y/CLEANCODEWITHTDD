package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

  @Test
  @DisplayName("숫자_검증")
  void 숫자_검증(){
    assertThat(ValidationUtils.validationNumber(9)).isTrue();
    assertThat(ValidationUtils.validationNumber(8)).isTrue();
    assertThat(ValidationUtils.validationNumber(0)).isFalse();
    assertThat(ValidationUtils.validationNumber(10)).isFalse();
  }
}
