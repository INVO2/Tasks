package com.company.Task3;

import java.util.Scanner;

public class Three {
    public void checkDoubl(int a,int b,int c){
        int sum=0;
        boolean find=false;
        for (int i = 0; i < 49; i++) {
            for (int j = 0; j < 49; j++) {
                sum=i*a+j*b;
                if(sum==c) {
                    if(i==0){
                        System.out.println((int)Math.pow(b,j));
                        find=true;
                    }else if (j==0){
                        System.out.println((int)Math.pow(a,i));
                        find=true;
                    }else {
                        System.out.println((int)Math.pow(a,i)*(int)Math.pow(b,j));
                        find=true;
                    }
                }
            }
        }
        if(!find) System.out.println(0);

    }
    public static void main(String[] args){
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Введите а: ");
                int a = new Scanner(System.in).nextInt();
                System.out.println("Введите b: ");
                int b = new Scanner(System.in).nextInt();
                System.out.println("Введите n: ");
                int n = new Scanner(System.in).nextInt();
                if (a>9|a<2|b>9|b<2|n>99|n<11) {
                    throw new Exception();
                } else new Three().checkDoubl(a,b,n);

            } catch (Exception e) {
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }
        }
    }




}
