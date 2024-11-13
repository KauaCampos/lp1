package br.cefetmg.inf.llp.lista15.p2591;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] Args){
        
        Scanner sc = new Scanner(System.in);
        
        int cont = sc.nextInt(); sc.nextLine();
        for (int contador = 0; contador < cont; contador++) {
            
            String golpe = sc.nextLine();
            int[] quant = new int[2];
            quant[0] = 0; quant[1] = 0;
            int i = 0;
            
            for (char ch : golpe.toCharArray()){
                if (ch == 'k')
                    i = 1;
                
                if (ch == 'a')
                    quant[i]++;
            }
            
            int quantidadeA = quant[0] * quant[1];
            StringBuilder as = new StringBuilder();
            while (!(quantidadeA == 0)){
                as.append('a');
                quantidadeA--;
            }
            
            System.out.println("k" + as);
        }
    }
}
