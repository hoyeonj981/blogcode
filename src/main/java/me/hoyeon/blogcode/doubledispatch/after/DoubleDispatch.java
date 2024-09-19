package me.hoyeon.blogcode.doubledispatch.after;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {

  public static void main(String[] args) {
    List<Drawable> drawableList = Arrays.asList(new Paper());
    List<Shape> shapeList = Arrays.asList(new Rectangle(), new Circle());

    drawableList.forEach(drawable -> shapeList.forEach(shape -> shape.accept(drawable)));
  }
}

interface Shape {
  void accept(Drawable drawable);
}

class Rectangle implements Shape {
  @Override
  public void accept(Drawable drawable) {
    drawable.draw(this);
  }
}

class Circle implements Shape {
  @Override
  public void accept(Drawable drawable) {
    drawable.draw(this);
  }
}

interface Drawable {
  void draw(Rectangle rectangle);
  void draw(Circle circle);
}

class Paper implements Drawable {

  @Override
  public void draw(Rectangle rectangle) {
    System.out.println("drawing rectangle");
  }

  @Override
  public void draw(Circle circle) {
    System.out.println("drawing circle");
  }
}
