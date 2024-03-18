package br.cefetmg.inf.llp.lista04.p1101;

import java.util.Scanner;

public class Main {
    
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        
        int x, y, aux, soma;
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x <= 0 || y <= 0)
                break;
            
            if (x > y) {
                aux = x;
                x = y;
                y = aux;
            }
            
            for (soma = 0; x <= y; soma += x, x++)
                System.out.print(x + " ");
            
            System.out.println("Sum=" + soma);
        }   
    }
}
