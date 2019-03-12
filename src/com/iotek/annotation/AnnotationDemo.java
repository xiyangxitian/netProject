package com.iotek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MyAnnotation1
@MyAnnotation2({"aa","bb"})
public class AnnotationDemo {

//    @MyAnnotation2(color=Color.BLUE,age=10)
    private static String name;
    @MyAnnotation2(value = {"aa","bb"})
    public AnnotationDemo(){

    }

    public static void main(String[] args) {
        name = "zhansan";
        System.out.println(name);
    }
    @MyAnnotation2({"aa","bb"})
    public void p(){

    }
}

enum Color {
    RED,BLUE,YELLOW;
}
//标记注解
@interface MyAnnotation1{

}
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.TYPE})
@interface MyAnnotation2{
//    String name() default "lisi";
//    Color color();
//    int age();
    String[] value();

}