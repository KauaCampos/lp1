package br.cefetmg.inf.llp.lista15.p2292;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        while (n-- > 0) {
            String[] entrada = sc.nextLine().split(" ");
            String painelInicial = entrada[0];
            long c = Long.parseLong(entrada[1]);

            char[] painel = painelInicial.toCharArray();
            int tamanho = painel.length;

            for (int i = 0; i < tamanho; i++) {
                if (c % 2 == 1) { 
                    painel[i] = painel[i] == 'O' ? 'X' : 'O';
                }

                c /= 2;
                if (c == 0) break; 
            }

            System.out.println(new String(painel));
        }

        sc.close();
    }
}