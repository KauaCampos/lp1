package br.cefetmg.inf.llp.lista15.p2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String initialConfig = input[0];
            long c = Long.parseLong(input[1]);

            StringBuilder painel = new StringBuilder(initialConfig);

            boolean primeiraLampadaLigada = painel.charAt(0) == 'O';
            if (c % 2 != 0) {
                primeiraLampadaLigada = !primeiraLampadaLigada;
            }
            painel.setCharAt(0, primeiraLampadaLigada ? 'O' : 'X');

            for (int j = 1; j < painel.length(); j++) {
                if (painel.charAt(j - 1) == 'X') {
                    painel.setCharAt(j, painel.charAt(j) == 'O' ? 'X' : 'O');
                }
            }

            System.out.println(painel.toString());
        }

        scanner.close();
    }
}

