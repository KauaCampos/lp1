package br.cefetmg.inf.llp.lista08.p1042_filaCircular;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        
        Fila fila = new Fila();
        
        int num;
        for (int i = 0; i < 3; i++) {
            num = sc.nextInt();
            fila.enfileirar(num);
        }
        
        Fila filaOrdenada = new Fila();
        No atual = fila.primeiro;
        do {
            filaOrdenada.enfileirar(atual.elemento);
            atual = atual.proximo;
        } while (atual != fila.primeiro);
        
        filaOrdenada.ordenar();
        
        while (filaOrdenada.tamanho > 0) {
            System.out.println(filaOrdenada.desinfileirar());
        }
        
        System.out.println();
        
        while (fila.tamanho > 0) {
            System.out.println(fila.desinfileirar());
        }
    }
}

class No {
    int elemento;
    No proximo;
    
    No(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}

class Fila {
    No primeiro;
    No ultimo;
    int tamanho;
    
    Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    void enfileirar(int elemento) {
        No novo = new No(elemento);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
            ultimo.proximo = primeiro;
        } 
        
        else {
            ultimo.proximo = novo;
            ultimo = novo;
            ultimo.proximo = primeiro;
        }
        tamanho++;
    }
    
    int desinfileirar() {
        if (tamanho > 0) {
            int elemento = primeiro.elemento;
            primeiro = primeiro.proximo;
            ultimo.proximo = primeiro;
            tamanho--;
            return elemento;
        } 
        
        else return -1;
        
    }
    
    void ordenar() {
        No atual = primeiro;
        No proximo;
        int temp;
    
        do {
            proximo = atual.proximo;
            do {
                if (atual.elemento < proximo.elemento) {
                    temp = atual.elemento;
                    atual.elemento = proximo.elemento;
                    proximo.elemento = temp;
                }
                proximo = proximo.proximo;
            } while (proximo != atual);
            atual = atual.proximo;
        } while (atual != primeiro);
    }   
}