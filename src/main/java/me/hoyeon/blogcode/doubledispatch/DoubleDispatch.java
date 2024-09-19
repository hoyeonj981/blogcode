package me.hoyeon.blogcode.doubledispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {

  public static void main(String[] args) {
    List<Drawable> drawableList = Arrays.asList(new Paper(), new Tablet());
    List<Shape> shapeList = Arrays.asList(new Rectangle(), new Circle());

    for (Shape shape : shapeList) {
      for (Drawable drawable : drawableList) {
        drawable.draw(shape);
      }
    }
  }
}

interface Shape {}

interface Drawable {
  void draw(Shape shape);
}

class Rectangle implements Shape {}
class Circle implements Shape {}

class Paper implements Drawable {

  @Override
  public void draw(Shape shape) {

  }
}

class Tablet implements Drawable {

  @Override
  public void draw(Shape shape) {

  }
}