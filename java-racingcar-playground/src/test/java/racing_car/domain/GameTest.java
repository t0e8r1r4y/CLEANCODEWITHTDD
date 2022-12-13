package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

  List<String> nameList;
  int count;

  @BeforeEach
  void setUp(){
    nameList = new ArrayList<>();
    nameList.add("pobi");
    nameList.add("crong");
    nameList.add("honux");
    count = 5;
  }

  @Test
  @DisplayName("게임 생성 테스트")
  void 게임_생성(){
    Game game = new Game(nameList, count);
    assertThat(game.getCount()).isEqualTo(count);
  }

  @Test
  @DisplayName("게임 결과 가져오기")
  void 게임_결과_반환(){
    Game game = new Game(nameList, count);
    Map<String, Integer> result = game.getResult();
    assertThat(result.get("pobi")).isEqualTo(0);
    assertThat(result.get("crong")).isEqualTo(0);
    assertThat(result.get("honux")).isEqualTo(0);
  }

  @Test
  @DisplayName("게임 결과 가져오기")
  void 게임_실행(){
    Game game = new Game(nameList, count);
    game.play();
  }


}
