package br.cefetmg.inf.llp.lista15.p2866;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    
    public static void main(String[] Args){
        
        Scanner sc = new Scanner(System.in);
        
        int cont = sc.nextInt(); sc.nextLine();
        for (int contador = 0; contador < cont; contador++) {
            
            String criptografia = sc.nextLine();
            Deque<Character> resultado = new ArrayDeque<>();
            
            for (char ch : criptografia.toCharArray()) 
                if (ch >= 'a' && ch <= 'z')
                    resultado.add(ch);
            
            while (!(resultado.isEmpty()))
                System.out.print(resultado.removeLast());
            
            System.out.println();
        }
    }
}
