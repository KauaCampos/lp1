package br.cefetmg.inf.llp.lista16.p1042_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            try {
                fila.add(sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número inteiro. Tente novamente.");
                sc.next();
                i--;
            }
        }

        Integer[] ordenado = fila.toArray(Integer[]::new);
        
        try {
            for (int i = 0; i < ordenado.length - 1; i++) {
                for (int j = 0; j < ordenado.length - i - 1; j++) {
                    if (ordenado[j] > ordenado[j + 1]) {
                        int temp = ordenado[j];
                        ordenado[j] = ordenado[j + 1];
                        ordenado[j + 1] = temp;
                    }
                }
            }

            for (int num : ordenado) {
                System.out.println(num);
            }

            System.out.println("");

            while (!fila.isEmpty()) {
                System.out.println(fila.remove());
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Tentativa de acessar um índice fora dos limites do array.");
        }

        sc.close();
    }
}