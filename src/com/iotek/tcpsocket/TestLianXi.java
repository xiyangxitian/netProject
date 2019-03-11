package com.iotek.tcpsocket;

import java.util.Scanner;

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
