package me.hoyeon.blogcode.doubledispatch;

public class SingleDispatch {

  public static void main(String[] args) {
    Printable printer1 = new StringPrinter();
    printer1.print();

    Printable printer2 = new IntegerPrinter();
    printer2.print();
  }
}

interface Printable {
  void print();
}

class StringPrinter implements Printable {

  @Override
  public void print() {
    System.out.println("hello world");
  }
}

class IntegerPrinter implements Printable {

  @Override
  public void print() {
    System.out.println(42);
  }
}