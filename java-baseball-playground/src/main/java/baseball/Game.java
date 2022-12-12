package baseball;

public class Game {

  private Balls answer;

  public Game(String answer) {
    this.answer = new Balls(answer);
  }

  public Balls getAnswer() {
    return answer;
  }

  public String compareAnswer(String userInput) {
    return answer.play(new Balls(userInput));
  }
}
