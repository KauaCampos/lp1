package br.cefetmg.inf.llp.lista02.p1008;

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
                
        int numFuncionario = sc.nextInt(), horasTrabalhadas = sc.nextInt();
        double salarioHora = sc.nextDouble();
        
        double salarioTotal = salarioHora * horasTrabalhadas;
        
        System.out.println("NUMBER = " + numFuncionario);
        System.out.printf("SALARY = U$ %.2f%n", salarioTotal);
    }
}