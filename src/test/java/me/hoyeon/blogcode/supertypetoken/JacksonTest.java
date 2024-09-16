package me.hoyeon.blogcode.supertypetoken;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JacksonTest {

  @Test
  void createObject() throws Exception {
    String json = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Jane\", \"age\":25}]";
    ObjectMapper objectMapper = new ObjectMapper();
    var users = objectMapper.readValue(json, new TypeReference<List<TestUser>>() {});
    System.out.println(users);
  }
}
