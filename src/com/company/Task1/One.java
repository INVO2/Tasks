package com.company.Task1;
import java.util.Scanner;

public class One implements ConstantsСheetah{

    double[] xArray;

    public void install(int t){
        xArray = new double[t];

        for (int i = 0; i < xArray.length; i++) {
            try {
                System.out.println("Введите х" + (i + 1) + ": ");
                double buf = Double.parseDouble(new Scanner(System.in).next().replace(',', '.'));
                if (buf > 1000 | buf < -1000) {
                    throw new Exception();
                } else {
                    xArray[i] = buf;
                }

            }catch (Exception e){
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }

        }

    }

    public void doMath(int t)  {
        install(t);
        double  s= xArray[0];


        for (int i = 0; i <t ; i++) {
            double  res = a*Math.pow(xArray[i],4)+ b*Math.pow(xArray[i],3)+c*Math.pow(xArray[i],2)+d*xArray[i]+ 123.456;
            System.out.println(String.format("%.3f", res));
        }

    }

    public static void main (String[] args)  {
        for (int i = 0; i <1 ; i++) {
            try {
                System.out.println("Введите количество уравнений: ");
                int buf = new Scanner(System.in).nextInt();
                if(buf>100|buf<1){
                    throw new Exception();
                }
                else {
                    new One().doMath(buf);
                }

            } catch (Exception e) {
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }

        }


    }
}
