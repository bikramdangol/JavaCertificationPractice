package com.company.oca;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i< 10 ; i = ++i){
            i+=1;
            System.out.println("hello");

        }
	// write your code here

        float fl = 12345 > 12345.1 ? 12345 : 12345.1f;
        int x = 12345;
        double d = x + fl;
        System.out.println(d);
    }
}
