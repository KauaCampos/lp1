package br.cefetmg.inf.llp.lista03.p1038;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double preco;
        int codigo = sc.nextInt(), quant = sc.nextInt();
        
        switch (codigo) {
            case 1:
                preco = 4.00;
                break;
                
            case 2:
                preco = 4.50;
                break;
            
            case 3: 
                preco = 5.00;
                break;
                
            case 4:
                preco = 2.00;
                break;
                
            default:
                preco = 1.50;
        }
        
        double precoPagar = preco * quant;
        System.out.printf("Total: R$ %.2f%n", precoPagar);
    }
}
