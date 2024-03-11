package br.cefetmg.inf.llp.lista03.p1035;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        int c = sc.nextInt(), d = sc.nextInt();

        if (b > c && d > a && a % 2 == 0 && (d + c) > (a + b) && c >= 0 && d >= 0) 
            System.out.println("Valores aceitos");
        else 
            System.out.println("Valores nao aceitos");
        
    }
}