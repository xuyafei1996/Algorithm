package test;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 1;
        int i=0;
        while(i++<4)
            num*=10;
        for (i = 1; i < num; i++) {
            System.out.println(i);
        }
    }
}
