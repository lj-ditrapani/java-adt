package info.ditrapani.adt;

sealed interface Lst {
  public String str();
}

record Nil() implements Lst {
  public String str() {
    return " )";
  }
}

record Cons(int head, Lst tail) implements Lst {
  public String toString() {
    return "Lst(" + str();
  }

  public String str() {
    return " " + head + tail.str();
  }
}

record Tup(int a, int b) {}

public class App {
  public static void main(String[] args) {
    Lst list = new Cons(3, new Cons(2, new Nil()));
    System.out.println(list.toString());

    Object obj = "hello";

    var tup = new Tup(1, 5);
    System.out.println(tup.a());
    System.out.println(listToMessage(list));
  }

  public static String listToMessage(Lst list) {
    return switch(list) {
      case Cons cons -> "I'm a cons with " + cons.head();
      case Nil nil -> "I'm a Nil";
    };
  }
}

sealed interface TailRec<T> {
  default public T eval() {
    var tailRec = this;
    while (true) {
      if (tailRec instanceof Suspend<T> suspend) {
        tailRec = suspend.step().apply();
      } else if (tailRec instanceof Return<T> ret) {
        return ret.value();
      }
    }
  }
}

record Suspend<T>(Step<T> step) implements TailRec<T> {}

record Return<T>(T value) implements TailRec<T> {}

interface Step<T> {
  public TailRec<T> apply();
}
