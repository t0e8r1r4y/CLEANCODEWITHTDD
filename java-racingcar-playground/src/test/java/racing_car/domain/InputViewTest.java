package racing_car.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

  private InputView inputView;

  @BeforeEach
  void setUp(){
    inputView = new InputView();
  }

  @DisplayName("입력 창 관련 - 이름 입력")
  @ParameterizedTest
  @ValueSource(strings = {"test1,test2,test3,test4"})
  void 뷰_생성_이름입력(String input){
    InputStream in = generateUserInput(input);
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);

    String names = scanner.next();
    inputView.setNames(names);
  }

  @DisplayName("입력 창 관련 - 게임 종료 기준 입력")
  @ParameterizedTest
  @ValueSource(strings = {"4"})
  void 뷰_생성_게임카운트입력(String input){
    InputStream in = generateUserInput(input);
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);

    String endCount = scanner.next();
    inputView.setEndCount(endCount);
  }

  public static InputStream generateUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

}
