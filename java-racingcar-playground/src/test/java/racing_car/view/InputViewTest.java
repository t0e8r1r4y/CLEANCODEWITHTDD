package racing_car.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

  private Scanner scanner;

  private InputView inputView;

  @BeforeEach
  void setUp(){
    inputView = new InputView();
  }

  public static InputStream generateUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

  @DisplayName("이름 입력 생성")
  @ParameterizedTest
  @ValueSource(strings = {"pobi,crong,honux"})
  void 입력_생성(String input){
    InputStream in = generateUserInput(input);
    System.setIn(in);
    scanner = new Scanner(System.in);
    String value = scanner.next();

    inputView.takeNames(value);
    List<String> nameList = inputView.getNames();

    assertThat(nameList.size()).isEqualTo(3);
    assertThat(nameList.get(0)).isEqualTo("pobi");
    assertThat(nameList.get(1)).isEqualTo("crong");
    assertThat(nameList.get(2)).isEqualTo("honux");
  }

  @DisplayName("전진 횟수 입력 생성")
  @ParameterizedTest
  @ValueSource(strings = {"5"})
  void 전진_횟수_입력_생성(String input){
    InputStream in = generateUserInput(input);
    System.setIn(in);
    scanner = new Scanner(System.in);
    int value = Integer.parseInt(scanner.next());

    inputView.takeForwardCount(value);
    int cnt = inputView.getForwardCount();

    assertThat(cnt).isEqualTo(value);
  }

  @Test
  @DisplayName("이름 입력 생성 실패")
  void 입력_생성_실패(){
    String value = "";
    assertThatThrownBy(()->inputView.takeNames(value))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
