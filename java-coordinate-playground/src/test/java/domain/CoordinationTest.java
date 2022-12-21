package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("좌표 생성 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CoordinationTest {

  @DisplayName("인스턴스 생성 테스트")
  @Test
  void 인스턴스_생성_성공_테스트(){
    int givenX = 1;
    int givenY = 2;
    new Coordination(givenX, givenY);
  }

  @DisplayName("인스턴스 생성 실패 테스트 - 입력 범위 이상으로 실패")
  @Test
  void 인스턴스_생성_실패_테스트(){
    int givenX = 60;
    int givneY = -1;
    assertThrows(IllegalArgumentException.class, ()-> new Coordination(givenX, givneY));
  }



  @DisplayName("인스턴스 생성 후 테스트")
  @Nested
  class WhenNew{

    private Coordination coordination = null;

    @BeforeEach
    void setUp(){
      int givenX = 10;
      int givenY = 10;
      coordination = new Coordination(givenX, givenY);
    }

    @ParameterizedTest(name = "생성된 객체늬 X좌표는 {0}, Y좌표는 {1}로 조회 됨")
    @CsvSource(value = {"10, 10"})
    void 좌표_조회(int expectedX, int expectedY){
      // given -> before setup
      // when
      int resultX = coordination.getX();
      int resultY = coordination.getY();
      // then
      assertThat(resultX).isEqualTo(expectedX);
      assertThat(resultY).isEqualTo(expectedY);

    }

  }

}
