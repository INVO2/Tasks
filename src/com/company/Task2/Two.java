package com.company.Task2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Two {

    Integer[] wearWheels;
    Integer[] backUp;
    int bBuf;
    int max=0;

    public Integer[] install(int a){
        Integer[] list = new Integer[a/2];
        backUp= new Integer[a/2];
        for (int i = 0; i <list.length ; i++) {
            try {
                System.out.println("Введите количество км до износа покрыщек на оси "+(i+1)+":");
                int buf = new Scanner(System.in).nextInt();
                if (buf>3000|bBuf<1){
                    throw new Exception();
                }
                else {
                    list[i] = buf;
                    if(list[i]>max)max=list[i];
                    backUp[i] = list[i];
                }

            }catch (Exception e){
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }

        }
        Arrays.sort(list, Collections.reverseOrder());
        Arrays.sort(backUp, Collections.reverseOrder());
        return list;
    }

    public double doEasy(int a,int b,double c,int k) {
        int fori;
        fori = (backUp[backUp.length-2] / backUp[backUp.length-1]);
        return c + backUp[backUp.length-1] / (fori + 1) * fori * 2 * k;
    }

    public void drive(int a, int b){
        bBuf=b;
        wearWheels=install(a);
       int check=0;
       double road=0;
       int minR=3000;
       if (b%a==0&a==4&b!=12&b!=16){
           road =doEasy(a,b,road,b/a);
       }
       else {
           for (int j = 0; j < backUp.length; j++) {
               if (minR >= backUp[j]){
                   minR=backUp[j];
               }
           }
           while (b-a>=0){
               for (int i = 0; i <wearWheels.length ; i++) {
                   wearWheels[i]-=1;
                   check++;
                   if (wearWheels[i]==0){
                       boolean ch=false;
                       if (((b-2==a)&(check<max)&(a==4))|((a!=4)&(b==a)&check<max)){
                           road=doEasy(a,b,road,1);
                           b=0;
                           if(b-a<0)break;
                       }else if(check > 5) {
                       road += minR;
                       ch = false;
                       b -= 2;
                       if (b - a < 0) break;
                       }else {
                           b-=2;
                           if(b-a<0)break;
                       }
                       check=0;
                       if(i==wearWheels.length-1){

                           for (int j = 0; j <wearWheels.length ; j++) {
                               if(wearWheels[j]==0){
                                   ch =true;
                               }
                               else {
                                   ch=false;
                                   break;
                               }
                           }
                           if(ch){
                               for (int j = 0; j <wearWheels.length ; j++) {
                                   wearWheels[j]=backUp[j];
                               }
                           }
                           else {
                               wearWheels[i]=backUp[i];
                           }
                       }
                   }
               }

           }
       }
        System.out.println(String.format("%.3f", road));
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <1 ; i++) {
            System.out.println("Введите количество колес: ");
            try {
                int n = scanner.nextInt();
                if (n < 4 & n > 10) {
                    throw new Exception();
                }
                System.out.println("Введите количество покрышек: ");
                int m = scanner.nextInt();
                if (m < n & m > 20) {
                    throw new Exception();
                }
                new Two().drive(n, m);
            } catch (Exception e) {
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }
        }
    }
}
