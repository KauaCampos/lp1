package br.cefetmg.inf.llp.lista04.p1071;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(), y = sc.nextInt(), aux;

        if (x > y) {
            aux = x;
            x = y;
            y = aux;
        }

        int xImpar;
        if (x % 2 == 0) 
            xImpar = x + 1;
        else 
            xImpar = x + 2;

        int soma = 0;
        while (xImpar < y) {
            soma += xImpar;
            xImpar += 2;
        }
        
        System.out.println(soma);
    }
}
