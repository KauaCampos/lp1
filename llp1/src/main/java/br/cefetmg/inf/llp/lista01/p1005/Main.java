package br.cefetmg.inf.llp.lista01.p1005;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double notaA = sc.nextDouble(), notaB = sc.nextDouble();
        
        double media = (notaA * 3.5 + notaB * 7.5) / 11;
        
        System.out.printf("MEDIA = %.5f%n", media);
    }
}