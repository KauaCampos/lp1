package br.cefetmg.inf.llp.lista08.p1042_fila;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        
        Fila fila = new Fila(3);
        
        int num;
        while (!(sc.hasNext())) {
            num = sc.nextInt();
            fila.enfileirar(num);
        }
    }
}

class Fila {
    Integer numeros[];
    int comeco;
    int fim;
    int tamanho;
    int capacidade;
    
    Fila (int capacidade) {
        this.capacidade = capacidade;
        numeros = new Integer[tamanho];
        tamanho = 0;
        comeco = 0;
        fim = -1;
    }
    
    void enfileirar (Integer elemento) {
        if (!(capacidade < tamanho)) {
            fim++;
            numeros[fim] = elemento;
            tamanho++;
        }
        
        else {
            Integer[] aux = new Integer[capacidade + 1];
            System.arraycopy(numeros, 0, aux, 0, capacidade);
            numeros = aux;
            aux = null;
        }
    }
    
    void desinfileirar (int elemento){
        
    }
  
}
