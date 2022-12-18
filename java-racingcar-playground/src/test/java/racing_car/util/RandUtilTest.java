package racing_car.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_car.util.RandUtil;


@DisplayName("랜덤 숫자 생성 테스트") @Nested
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RandUtilTest {

  @DisplayName("필요한 갯수만큼 랜덤으로 숫자를 생성합니다.")
  @ParameterizedTest
  @ValueSource(ints = {1})
  void 랜덤_숫자_생성(int num){
    RandUtil randUtil = new RandUtil(num);
    assertThat(randUtil.getList().size()).isEqualTo(num);
  }

  @DisplayName("생성한 숫자의 범위가 1~9인지 확인")
  @ParameterizedTest
  @ValueSource(ints = {3})
  void 랜덤_숫자_범위_확인(int num){
    RandUtil randUtil = new RandUtil(num);
    List<Integer> numberList = randUtil.getList();

    for( int number : numberList){
      assertThat(number).isGreaterThan(0);
      assertThat(number).isLessThan(10);
    }
  }
}
