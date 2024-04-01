package br.cefetmg.inf.llp.lista06.p1245;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {    
        Scanner sc = new Scanner(System.in);
        
        int p[][] = new int [31] [2];
        int quant, tamanho, aux, quantPares, troca;
        char lado;
        
        while (sc.hasNext()) {
            quant = sc.nextInt();
            
            for (int i = 0; i < 31; i++) 
                for (int j = 0; j < 2; j++)
                    p [i] [j] = 0;
            
            for (int cont = 0; cont < quant; cont++){
                tamanho = sc.nextInt();
                lado = sc.next().charAt(0);
                
                if (lado == 'E')
                    aux = 0;
                else
                    aux = 1;
                p [tamanho - 30] [aux] ++;
            }
            
            quantPares = 0;
            for (int i = 0; i < 31; i++) {
                if (p [i] [0] == 0 || p [i] [1] == 0)
                    continue;
        
                if (p [i] [1] > p [i] [0]) {
                    troca = p [i] [1];
                    p [i] [1] = p [i] [0];
                    p [i] [0] = troca;
                }
                quantPares += p [i] [1];
            } 
            
            System.out.println(quantPares);
        }
    }
}
