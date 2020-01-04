package com.company.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Four {

    public List table;

    public boolean workDone(){
        boolean work= false;
        for (int i = 0; i < table.indexOf(0); i++) {
            if(table.get(i).equals(2)){
                work = true;
            }
            else{
                work = false;
                break;
            }
        }
        if(work){
            for (int i = table.indexOf(0)+1; i <table.size() ; i++) {
                if(table.get(i).equals(1)){
                    work=true;
                }
                else{
                    work = false;
                    break;
                }
            }
        }
        return work;
    }

    public boolean checkGo(){
        boolean checkOne=false;
        boolean checkSecond=false;
        tut:{
        for (int i = 0; i <table.indexOf(0); i++) {
            if(!table.get(i).equals(1)){
                checkOne=false;
                break ;
            }
            else {
                checkOne=true;

            }
        }
        if (checkOne)break tut;
        for (int i = table.indexOf(0)+1; i <table.size(); i++) {
            if(!table.get(i).equals(1)){
                checkOne=false;
                break ;
            }
            else {
                checkOne=true;
            }


        }
        if (checkOne)break tut;
        for (int i = 0; i <table.indexOf(0); i++) {
            if(!table.get(i).equals(2)){
                checkSecond=false;
                break ;
            }
            else {checkSecond=true;

            }

        }
        if (checkSecond)break tut;
        for (int i = table.indexOf(0)+1; i <table.size(); i++) {
            if(!table.get(i).equals(2)){
                checkSecond=false;
                break ;
            }
            else {
                checkSecond=true;
            }


        }
        if (checkSecond)break tut;

        }
        if (checkOne){
            return true;
        }else if (checkSecond)return false;
        return Boolean.parseBoolean(null);
    }

    public void setTable(int a,int b) {
        table=new ArrayList();
        for (int i = 0; i < a; i++) {
            table.add(1);
        }
        table.add(0);
        for (int i = 0; i <b ; i++) {
            table.add(2);
        }
    }

    private void replace(int a, int b){
        setTable(a, b);
        boolean lock = true;
        int iteration=0;
        boolean start = true;
        while (lock){
            lock=false;
            first:{
                if (start){
                    for (int i = 1; i < table.size(); i++) {
                        if (table.get(i).equals(0) & table.get(i - 1).equals(1)) {
                            table.set(i - 1, 0);
                            table.set(i, 1);
                            lock = true;
                            start=false;
                            iteration++;

                            break first;
                        }
                    }
                }
                for (int i = 2; i < table.size(); i++) {
                    if (table.get(i).equals(0) & table.get(i-1).equals(2) & table.get(i-2).equals(1)){
                        table.set(i, 1);
                        table.set(i - 2, 0);
                        lock = true;
                        iteration++;

                        break first;
                    }
                }
                for (int i = 2; i < table.size(); i++) {
                    if (table.get(i).equals(2) & table.get(i-1).equals(1) & table.get(i-2).equals(0)){
                        table.set(i, 0);
                        table.set(i - 2, 2);

                        lock = true;
                        iteration++;

                        break first;
                    }
                }
                if (table.get(0).equals(0) & table.get(1).equals(2)) {
                    table.set(1, 0);
                    table.set(0, 2);
                    lock = true;
                    iteration++;

                    break first;
                }
                if (table.get(table.size() - 1).equals(2) & table.get(table.size() - 2).equals(0)) {
                    table.set(table.size() - 1, 0);
                    table.set(table.size() - 2, 2);
                    lock = true;
                    iteration++;

                    break first;
                }
                if (table.get(table.size() - 1).equals(0) & table.get(table.size() - 2).equals(1)) {
                    table.set(table.size() - 1, 1);
                    table.set(table.size() - 2, 0);
                    lock = true;
                    iteration++;

                    break first;
                }
                if (table.get(0).equals(1) & table.get(1).equals(0)) {
                    table.set(1, 1);
                    table.set(0,0 );
                    lock = true;
                    iteration++;
                    break first;
                }
                if(!workDone()){
                    if (checkGo()){
                        for (int i = 2; i < table.size(); i++) {
                            if (table.get(i).equals(0) & table.get(i - 1).equals(1)) {
                                table.set(i - 1, 0);
                                table.set(i, 1);
                                lock = true;
                                iteration++;


                                break first;
                            }
                        }
                    }
                    if (!checkGo()){
                        for (int i = 2; i < table.size(); i++) {
                            if(table.get(i-1).equals(2)&table.get(i-2).equals(0)){
                                table.set(i-1,0);
                                table.set(i-2,2);
                                lock = true;
                                iteration++;

                                break first;
                            }

                        }
                    }
                }


        }}
        System.out.println("Iterations = "+iteration);
    }

    public static void main(String[] args){

        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Введите n:");
                int n = new Scanner(System.in).nextInt();

                System.out.println("Введите m:");
                int m = new Scanner(System.in).nextInt();

                if(n>1000|n<1|m>1000|m<1){
                    throw new Exception();
                }else new Four().replace(n,m);

            }catch (Exception e){
                System.out.println("Ошибка ввода, повторите ввод");
                i--;
            }
        }

    }
}


