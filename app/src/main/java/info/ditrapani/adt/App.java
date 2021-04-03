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


public class App {

    public static void main(String[] args) {
        var list = new Cons(3, new Cons(2, new Nil()));
        System.out.println(list.toString());
    }
}
