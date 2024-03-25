package br.cefetmg.inf.llp.lista05.p1985;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int cont = sc.nextInt(), codigo, quant;
        double preco = 0;
        
        for (int i = 0; i < cont; i++) {
            codigo = sc.nextInt(); 
            quant = sc.nextInt();
            
            switch (codigo) {
                case 1001:
                    preco += 1.5 * quant;
                    break;
                    
                case 1002:
                    preco += 2.5 * quant;
                    break;
                    
                case 1003:
                    preco += 3.5 * quant;
                    break;
                    
                case 1004:
                    preco += 4.5 * quant;
                    break;
                    
                default:
                    preco += 5.5 * quant;
            }
        }
        
        System.out.printf("%.2f%n", preco);
    }
}
