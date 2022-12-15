package racing_car;

import racing_car.domain.Game;
import racing_car.domain.InputView;
import racing_car.domain.OutputView;

public class MainApplication {

  private static InputView inputView = new InputView();
  private static OutputView outputView = new OutputView();

  public static void main(String[] args) {
    inputView.printInputMessageForNames();
    inputView.printInputMessageForEndCount();

    Game game = new Game(inputView.toDto());
    outputView.printRacingResult(game.play());

  }
}
