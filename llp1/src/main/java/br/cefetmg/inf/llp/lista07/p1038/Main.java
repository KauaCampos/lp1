package br.cefetmg.inf.llp.lista07.p1038;

import java.util.Scanner;

class Lanche {
    int codigo;
    double preco;
    
    Lanche (int x) {
        this.codigo = x;      
    }
    
    void calcularPreco () {
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
    }
    
    double calcularTotal (int quant) {
        return preco * quant;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
    
        int codigo, quant;
        codigo = sc.nextInt();
        quant = sc.nextInt();
        
        Lanche lanche = new Lanche(codigo);
        lanche.calcularPreco();
        
        double total = lanche.calcularTotal(quant);
        System.out.printf("Total: R$ %.2f%n", total);
    }
}
