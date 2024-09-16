package me.hoyeon.blogcode.supertypetoken;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Type;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TypeReferenceTest {

  @Test
  void getGenericType() {
    TypeReference<List<String>> typeReference = new TypeReference<>() {};
    String expected = "java.util.List<java.lang.String>";

    String typeName = typeReference.getType().getTypeName();

    Assertions.assertThat(typeName).isEqualTo(expected);
  }
}