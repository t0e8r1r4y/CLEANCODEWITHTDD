package domain;

import java.util.ArrayList;
import java.util.List;

public class Coordinations {

  public static final int MAX_COORDINATION = 4;
  private List<Coordination> coordinationList;

  public Coordinations() {
    this.coordinationList = new ArrayList<>();
  }

  public Coordination get(int index) {
    if(this.coordinationList.size() < index + 1)
      throw new IllegalArgumentException("조회하려는 index가 전체 List의 크기보다 큽니다.");
    return this.coordinationList.get(index);
  }

  public boolean add(Coordination coordination) {
    if(this.coordinationList.size() == MAX_COORDINATION) return false;
    this.coordinationList.add(coordination);
    return true;
  }

  public int size() {
    return this.coordinationList.size();
  }

  public List<Coordination> getAll() {
    return this.coordinationList;
  }
}
