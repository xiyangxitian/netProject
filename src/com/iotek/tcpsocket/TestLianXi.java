package com.iotek.tcpsocket;

import java.util.Scanner;

/**
 * 练习下，项目 这个项目完结了
 * socket编程加url 其实应该把io也加上的
 * 不过没必要因为要常练习才是
 */
public class TestLianXi {

    public static void main(String[] args) {

        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入A:");
                int a = scanner.nextInt();
                System.out.println("请输入B:");
                int b = scanner.nextInt();
                if (a == 0 || b == 0) {
                    break;
                }
                System.out.println("b除a=" + a / b);
            }
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        } finally {
            System.out.println("finally....");
        }


    }
}
