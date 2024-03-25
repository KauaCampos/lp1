package br.cefetmg.inf.llp.lista05.p1067;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++)
            if (!(i % 2 == 0))
                System.out.println(i);
    }
}
