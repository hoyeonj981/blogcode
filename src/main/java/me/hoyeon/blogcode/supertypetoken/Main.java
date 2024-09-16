package me.hoyeon.blogcode.supertypetoken;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    Foo anonymousClass = new Foo<List<String>>() {};
  }
}

abstract class Foo<T> {};