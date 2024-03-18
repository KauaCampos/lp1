package br.cefetmg.inf.llp.lista04.p2060;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int multiplo2 = 0, multiplo3 = 0, multiplo4 = 0, multiplo5 = 0, num, cont = sc.nextInt();
        
        for (int i = 0; i < cont; i++) {
            num = sc.nextInt();
            
            if (num % 2 == 0)
                multiplo2++;
            if (num % 3 == 0)
                multiplo3++;
            if (num % 4 == 0)
                multiplo4++;
            if (num % 5 == 0)
                multiplo5++;
        }
        
        System.out.println(multiplo2 + " Multiplo(s) de 2");
        System.out.println(multiplo3 + " Multiplo(s) de 3");
        System.out.println(multiplo4 + " Multiplo(s) de 4");
        System.out.println(multiplo5 + " Multiplo(s) de 5");
    }
}
