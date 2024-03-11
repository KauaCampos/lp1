package br.cefetmg.inf.llp.lista02.p1010;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
                
        int codigo1 = sc.nextInt(), quant1 = sc.nextInt();
        double preco1 = sc.nextDouble();
        
        int codigo2 = sc.nextInt(), quant2 = sc.nextInt();
        double preco2 = sc.nextDouble();
        
        double valor = (quant1 * preco1) + (quant2 * preco2);
        System.out.printf("VALOR A PAGAR: R$ %.2f%n", valor);
    }
}