package br.cefetmg.inf.llp.lista04.p1094;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cont = sc.nextInt(), total = 0, coelhos = 0, ratos = 0, sapos = 0, num;
        char cobaia;
        
        for (int i = 0; i < cont; i++) {
            num = sc.nextInt();
            cobaia = sc.next().charAt(0);
            
            total += num;
            switch(cobaia) {
                case 'C': 
                    coelhos += num;
                    break;
                    
                case 'R': 
                    ratos += num;
                    break;
                    
                default:
                    sapos += num;
            }
        }
        
        System.out.println("Total: " + total +" cobaias");
        System.out.println("Total de coelhos: " + coelhos);
        System.out.println("Total de ratos: " + ratos);
        System.out.println("Total de sapos: " + sapos);
        
        double percentualCoelhos = coelhos * 100 / (double) total;
        double percentualRatos = ratos * 100 / (double) total;
        double percentualSapos = sapos * 100 / (double) total;
        System.out.printf ("Percentual de coelhos: %.2f %%%n", percentualCoelhos);
        System.out.printf ("Percentual de ratos: %.2f %%%n", percentualRatos);
        System.out.printf ("Percentual de sapos: %.2f %%%n", percentualSapos);
    }
}
