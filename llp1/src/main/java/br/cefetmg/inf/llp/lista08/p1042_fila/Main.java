package br.cefetmg.inf.llp.lista08.p1042_fila;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        
        Fila fila = new Fila(3);
        
        int num;
        for (int i = 0; i < 3; i++) {
            num = sc.nextInt();
            fila.enfileirar(num);
        }
        
        Fila filaOrdenada = new Fila(3);
        for (int numero : fila.numeros) filaOrdenada.enfileirar(numero);
        
        Arrays.sort(filaOrdenada.numeros);
        
        while (filaOrdenada.tamanho > 0) {
            System.out.println(filaOrdenada.desinfileirar());
        }
        
        System.out.println();
        
        while (fila.tamanho > 0) {
            System.out.println(fila.desinfileirar());
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
        numeros = new Integer[capacidade];
        tamanho = 0;
        comeco = 0;
        fim = -1;
    }
    
    void enfileirar (Integer elemento) {
        if (tamanho < capacidade) {
            fim = (fim + 1) % capacidade;
            numeros[fim] = elemento;
            tamanho++;
        } 
        
        else {
            Integer[] aux = new Integer[capacidade + 1];
            System.arraycopy(numeros, 0, aux, 0, capacidade);
            numeros = aux;
            aux = null;
            fim = capacidade - 1;
            numeros[fim] = elemento;
            tamanho++;
    }
}
    
    Integer desinfileirar () {
        if (tamanho > 0) {
            Integer elemento = numeros[comeco];
            comeco = (comeco + 1) % capacidade;
            tamanho--;
            return elemento;
        } 
        else return null;
    }
}