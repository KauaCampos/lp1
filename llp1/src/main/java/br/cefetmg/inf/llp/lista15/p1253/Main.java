package br.cefetmg.inf.llp.lista15.p1253;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int cont = sc.nextInt(); 
        sc.nextLine();  
        
        for (int i = 0; i < cont; i++) {
            String original = sc.nextLine();
            int num = sc.nextInt();
            sc.nextLine();
            
            StringBuilder resultado = new StringBuilder();
            for (char ch : original.toCharArray()) {
                ch = (char) (ch - num);
                
                if (ch < 'A') {
                    ch = (char) ('Z' - ('A' - ch - 1));
                }
                
                resultado.append(ch);
            }
            
            System.out.println(resultado);
        }
        
        sc.close();
    }
}
