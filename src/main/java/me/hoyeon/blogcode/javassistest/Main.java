package me.hoyeon.blogcode.javassistest;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

public class Main {

  public static void main(String[] args) throws Exception {
    ClassPool classPool = ClassPool.getDefault();
    CtClass ctClass = classPool.get("me.hoyeon.blogcode.javassistest.Main");
    System.out.println(ctClass.getName());
  }

  public static void doSomething() {
    throw new RuntimeException("no body");
  }

  static void testMethod() throws Exception {
    ClassPool classPool = ClassPool.getDefault();
    classPool.appendClassPath("me.hoyeon.blogcode.javassistest");
    CtClass ctClass = classPool.get("me.hoyeon.blogcode.javassistest.Main");
    String methodBody = "System.out.println(\"hello world\");";
    CtMethod method = ctClass.getDeclaredMethod("doSomething");
    method.insertBefore(methodBody);

    doSomething();
  }
}
