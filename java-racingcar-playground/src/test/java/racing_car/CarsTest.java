package racing_car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

  List<String> givenList;

  @BeforeEach
  void setUp(){
    givenList = new ArrayList<>();
    givenList.add("pobi");
    givenList.add("crong");
    givenList.add("honux");
  }

  @Test
  @DisplayName("경주용 차량들 생성")
  void 경주차들_생성(){
    Cars car = new Cars(givenList);
    assertThat(car.getCarsNum()).isEqualTo(givenList.size());
  }

  @Test
  @DisplayName("경주용 차량 전진")
  void  경주차들_전진(){
    List<Integer> numList = new ArrayList<>();
    numList.add(1);
    numList.add(4);
    numList.add(9);

    Cars car = new Cars(givenList);
    car.move(numList);
    assertThat(car.getCarList().get(0).getMoving().getMovingForwardcnt()).isEqualTo(0);
    assertThat(car.getCarList().get(1).getMoving().getMovingForwardcnt()).isEqualTo(1);
    assertThat(car.getCarList().get(2).getMoving().getMovingForwardcnt()).isEqualTo(1);
  }

  // TODO - 한턴씩 반복하면서 종료되는 조건을 찾지말고, 처음부터 종료가 되는 게임을 만들고 보여주는 것만 한 단계씩 변화하는 것으로 보여주는 로직 구현
  @Test
  @DisplayName("경주용 차량 기준 도달 여부 체크")
  void 완주체크(){
    int given = 1;
    List<Integer> numList = new ArrayList<>();
    numList.add(1);
    numList.add(4);
    numList.add(9);

    Cars car = new Cars(givenList);
    car.move(numList);
    Map<String, Integer> map =  car.getMovingForwardCntList();

    StringBuilder sb = new StringBuilder();
    Iterator<String> keys = map.keySet().iterator();
    while(keys.hasNext()){
      String key = keys.next();
      int forwardCnt = map.get(key);
      checkEnd(given, sb, key, forwardCnt);
    }

    assertThat(sb.toString()).isEqualTo("crong, honux, ");
  }

  private void checkEnd(int given, StringBuilder sb, String key, int forwardCnt) {
    if(forwardCnt == given){
      sb.append(key + ", ");
    }
  }

}
