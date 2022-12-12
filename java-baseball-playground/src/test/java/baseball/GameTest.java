package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GameTest {

  Game game;

  @BeforeEach
  void setUp(){
    game = new Game("123");
  }

  @Test
  @DisplayName("게임생성 테스트")
  void 게임_생성(){
    assertThat(game.getAnswer().getBalls().get(0).getNumber()).isEqualTo(1);
    assertThat(game.getAnswer().getBalls().get(1).getNumber()).isEqualTo(2);
    assertThat(game.getAnswer().getBalls().get(2).getNumber()).isEqualTo(3);
  }

  @Test
  @DisplayName("게임 진행 테스트")
  void 게임_진행(){
    String result = game.compareAnswer("123");
    assertThat(result).isEqualTo("3S");
  }

}
