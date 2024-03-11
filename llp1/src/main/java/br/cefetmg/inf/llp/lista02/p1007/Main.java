package br.cefetmg.inf.llp.lista02.p1007;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        int diferenca = a * b - c * d;

        System.out.println("DIFERENCA = " + diferenca);
    }
}
