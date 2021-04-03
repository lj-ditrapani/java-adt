package info.ditrapani.adt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TailRecTest {

  @Test
  public void executesOnceIfAtBaseCase() {
    TailRec subject = new Return(5);
    assertEquals(subject.eval(), 5);
  }

  @Test
  public void recursesUntilBaseCaseHit() {
    TailRec subject = factorial(1, 4);
    assertEquals(subject.eval(), 24);
  }

  @Test
  public void doesNotBlowStack() {
    TailRec subject = decrementer(99999);
    assertEquals(subject.eval(), 0);
  }

  @Test
  public void checkStackLimit() {
    assertThrows(StackOverflowError.class, () -> unsafeDecrementer(50000));
  }

  public TailRec factorial(int acc, int value) {
    if (value == 1) {
      return new Return(acc);
    } else {
      return new Suspend(() -> factorial(acc * value, value - 1));
    }
  }

  public TailRec decrementer(int count) {
    if (count == 0) {
      return new Return(count);
    } else {
      return new Suspend(() -> decrementer(count - 1));
    }
  }

  public int unsafeDecrementer(int count) {
    return count == 0 ? count : unsafeDecrementer(count - 1);
  }
}
