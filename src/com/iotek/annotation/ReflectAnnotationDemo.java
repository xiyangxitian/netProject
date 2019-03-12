package com.iotek.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class ReflectAnnotationDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.iotek.annotation.AnnotationTest");
        //这个类是否用了这个注解
        boolean flag = clazz.isAnnotationPresent(Description.class);
        if (flag) {
            Description description = clazz.getAnnotation(Description.class);
            System.out.println("--->>" + description.value());
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {

            if (m.isAnnotationPresent(Author.class)) {
                Author author = m.getAnnotation(Author.class);
                System.out.println("Author'name :" + author.name() + " from " + author.group());
            }

        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
@interface Author {
    String name();

    String group();
}

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@interface Description {

    String value();

}

@Description("这是一个测试用的类")
class AnnotationTest {
    @Author(name = "chenhao", group = "com.iotek")
    public void test() {
        System.out.println("test...");
    }
}