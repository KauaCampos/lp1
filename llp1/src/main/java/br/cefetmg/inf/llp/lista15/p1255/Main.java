package br.cefetmg.inf.llp.lista15.p1255;

import java.util.Scanner;

public class Main {
   
    public static void main (String[] Args){
        
        Scanner sc = new Scanner(System.in);
        
        String frase;
        int cont = sc.nextInt(), maiorQuant;
        sc.nextLine();
        for (int contador = 0; contador < cont; contador++) {
            
            frase = sc.nextLine();
            frase = frase.toLowerCase();

            int[] frequencia = new int[26];
            for (int i = 0; i < 26; i++)
                frequencia[i] = 0;
            
            for (char ch : frase.toCharArray()) 
                if ((ch >= 'a' && ch <= 'z')) 
                    frequencia[ch - 'a']++;
                
            maiorQuant = frequencia[0];
            for (int i = 1; i < 26; i++)
                if (frequencia[i] > maiorQuant)
                    maiorQuant = frequencia[i];
            
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < 26; i++)
                if (frequencia[i] == maiorQuant)
                    resultado.append((char) ('a' + i));
            
            System.out.println(resultado);
        }
    }
}
