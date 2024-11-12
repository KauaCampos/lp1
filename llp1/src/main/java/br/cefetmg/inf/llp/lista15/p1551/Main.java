package br.cefetmg.inf.llp.lista15.p1551;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] Args){
        
        Scanner sc = new Scanner(System.in);
       
        int cont = sc.nextInt(); sc.nextLine();
        for (int contador = 0; contador < cont; contador++) {
            
            boolean[] ocorrencias = new boolean[26];
            String frase = sc.nextLine();
            frase = frase.toLowerCase();
            
            for (char ch : frase.toCharArray())
                if (ch >= 'a' && ch <= 'z')
                    ocorrencias[ch - 'a'] = true;
            
            int quantLetras = 0;
            for (boolean cond : ocorrencias)
                if (cond) quantLetras++;
            
            if (quantLetras < 13) System.out.println("frase mal elaborada");
            else if (quantLetras < 26) System.out.println("frase quase completa");
            else System.out.println("frase completa");
        }
    }
}
