package br.cefetmg.inf.llp.lista05.p1134;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int gasolina = 0, alcool = 0, diesel = 0, escolha;
        while (true) {
            escolha = sc.nextInt();
            if (escolha == 4)
                break;
            
            switch (escolha){
                case 1:
                    alcool++;
                    break;
                    
                case 2:
                    gasolina++;
                    break;
                    
                case 3:
                    diesel++;
            }
        }
        
        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + alcool);
        System.out.println("Gasolina: " + gasolina);
        System.out.println("Diesel: " + diesel);
    }
}
