package Cookies;

public class HistoryDataLine {
  private final int op1;
  private final int op2;
  private final String op;
  private final int res;

  private final int user;

  public HistoryDataLine(int op1, int op2, String op, int res, int user) {
    this.op1 = op1;
    this.op2 = op2;
    this.op = op;
    this.res = res;
    this.user = user;
  }

  public int getOp1() {
    return op1;
  }

  public int getOp2() {
    return op2;
  }

  public String getOp() {
    return op;
  }

  public int getRes() {
    return res;
  }

  public int getUser() {
    return user;
  }

  @Override
  public String toString() {
    return String.format("%d %s %d = %d", op1, op, op2, res);
  }
}
