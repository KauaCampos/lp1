package br.cefetmg.inf.llp.lista01.p1003;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num1 = sc.nextInt(), num2 = sc.nextInt();
        
        int soma = num1 + num2;
        
        System.out.println("SOMA = " + soma);
    }
}