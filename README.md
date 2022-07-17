Algebraic Data Types in Java 17
===============================


UPDATE: workes with Java 17!
----------------------------


I've mostly been working in statically typed languages with reasonable type systems for the past 5 years; scala, kotlin, typescript, rust.
I've actively avoided Java.

However, since I saw Jake Wharton's talk on Java 19 <https://www.youtube.com/watch?v=te3OU9fxC8U>, I've been paying attention to Java major releases.

With the new features that have landed in Java over the past year, I thought I would take a second look at Java.
I decided to look into Java 16 to see if I can use algebraic data types (ADTs), a language feature I just can't live without.

Looking at the features list of Java 16
<http://openjdk.java.net/projects/jdk/16/>
and the features that preceded it in Java 14 & 15
<https://en.wikipedia.org/wiki/Java_version_history>,
we can see that Java 16 has:

- JEP 361: Switch Expressions (Standard)
- JEP 394: Pattern Matching for instanceof
- JEP 395: Records
- JEP 397: Sealed Classes (Second Preview)

Sounds like all the ingredients for ATDs, right?

From the JEP 397 description:

> Sealing a class restricts its subclasses. User code can inspect an instance of a sealed class with an if-else chain of instanceof tests, one test per subclass; **no catch-all else clause is needed**. For example, the following code looks for the three permitted subclasses of Shape:

```java
Shape rotate(Shape shape, double angle) {
    if (shape instanceof Circle) return shape;
    else if (shape instanceof Rectangle) return shape.rotate(angle);
    else if (shape instanceof Square) return shape.rotate(angle);
    // no else needed!
}
```

With java 17, we get the below implemented.  So this now works.

- JEP 405: Record Patterns & Array Patterns (Preview)
  <https://openjdk.java.net/jeps/405>
- JEP 406: Pattern Matching for switch (Preview)
  <https://openjdk.java.net/jeps/406>

I implemented a `TailRec` sealed interface for stack-safe recursion in Java inspired by this implementation
<https://freecontent.manning.com/stack-safe-recursion-in-java/>.
See
[app/src/main/java/info/ditrapani/adt/App.java](app/src/main/java/info/ditrapani/adt/App.java)
and
[app/src/test/java/info/ditrapani/adt/TailRecTest.java](app/src/test/java/info/ditrapani/adt/TailRecTest.java).


Develop
-------

    ./gradlew run
    ./gradlew test
