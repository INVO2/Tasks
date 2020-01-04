package com.company.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Three {
    public void checkDoubl(int a,int b,int c){
        ArrayList findList = new ArrayList();
        int sum=0;
        boolean find=false;
        for (int i = 0; i < 49; i++) {
            for (int j = 0; j < 49; j++) {
                sum=i*a+j*b;
                if(sum==c) {
                    if(i==0){
                        findList.add(Math.pow(b,j));
                        find=true;

                    }else if (j==0){
                        findList.add(Math.pow(a,i));
                        find=true;
                    }else {
                        findList.add(Math.pow(a,i)*Math.pow(b,j));
                        find=true;
                        break;
                    }
                }
            }
        }
        if(!find) {
            System.out.println(0);
        }
        else System.out.println(Collections.max(findList));

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
