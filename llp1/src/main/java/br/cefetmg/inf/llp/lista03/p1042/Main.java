package br.cefetmg.inf.llp.lista03.p1042;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //maior, medio, menor
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), aux;
        int num1 = a, num2 = b, num3 = c;
        
        if (b > a) {
            aux = a;
            a = b;
            b = aux;
        }
        
        if (c > a) {
            aux = a;
            a = c;
            c = aux;
        }
        
        if (c > b) {
            aux = b;
            b = c;
            c = aux;
        }
        
        System.out.println(c + "\n" + b + "\n" + a + "\n");
        System.out.println(num1 + "\n" + num2 + "\n" + num3);
    }
}
