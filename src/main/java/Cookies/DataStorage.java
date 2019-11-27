package Cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorage {
  private final List<HistoryDataLine> data = new ArrayList<>();

  public DataStorage() {
    data.add(new HistoryDataLine(1,2,"+", 3, 1));
    data.add(new HistoryDataLine(2,2,"+", 4, 1));
    data.add(new HistoryDataLine(10,20,"+", 3, 2));
    data.add(new HistoryDataLine(20,20,"+", 4,  2));
  }

  public List<HistoryDataLine> get() {
    return data;
  }

  public List<HistoryDataLine> getById(int user) {
    return data.stream().filter(d -> d.getUser() == user).collect(Collectors.toList());
  }

  public void add(int op1, int op2, String op, int res, int user) {
    data.add(new HistoryDataLine(op1, op2, op, res, user));
  }
}
