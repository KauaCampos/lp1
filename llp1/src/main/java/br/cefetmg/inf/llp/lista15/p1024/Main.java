package br.cefetmg.inf.llp.lista15.p1024;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] Args){
        
        Scanner sc = new Scanner(System.in);
        
        int quant = sc.nextInt();
        sc.nextLine();
        
        for (int cont = 0; cont < quant; cont++){
            
            String frase = sc.nextLine();

            StringBuilder resultado = new StringBuilder();
            for (char ch : frase.toCharArray()) {
                
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) 
                    resultado.append((char) (ch + 3));
                
                else 
                    resultado.append(ch);
            }

            resultado.reverse();

            int metade= resultado.length() / 2;
            for (int i = metade; i < resultado.length(); i++) {
                resultado.setCharAt(i, (char) (resultado.charAt(i) - 1));
            }
            
            System.out.println(resultado);
        }
        
        sc.close();
    }
}
