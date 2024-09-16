package me.hoyeon.blogcode.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {

  private final Type type;

  public TypeReference() {
    Type superClass = getClass().getGenericSuperclass();
    this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
  }

  public Type getType() {
    return this.type;
  }
}
