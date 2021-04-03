package info.ditrapani.adt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TailRecTest {

  @Test public void executesOnceIfAtBaseCase() {
  TailRec subject = new Return(5);
  assertEquals(subject.eval(), 5);
  }

  @Test public void recursesUntilBaseCaseHit() {
  TailRec subject = factorial(1, 4);
  assertEquals(subject.eval(), 24);
  }

  public TailRec factorial(int acc, int value) {
    if (value == 1) {
      return new Return(acc);
    } else {
      return new Suspend(() -> factorial(acc * value, value - 1));
    }
  }
}
