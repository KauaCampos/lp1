package br.cefetmg.inf.llp.lista17.p1042_List;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            try {
                lista.add(sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número inteiro. Tente novamente.");
                sc.next();
                i--;
            }
        }

        Integer[] ordenado = lista.toArray(Integer[]::new);
        
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

            for (Integer num : lista) {
                System.out.println(num);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Tentativa de acessar um índice fora dos limites do array.");
        }

        sc.close();
    }
}