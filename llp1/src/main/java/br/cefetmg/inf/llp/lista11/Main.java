package br.cefetmg.inf.llp.lista11;

import java.util.Scanner;

class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

abstract class Fila {
    public abstract void enfileirar(Integer item);
    public abstract void desenfileirar();
    public abstract boolean vazia();
    public abstract int tamanhoFila();
    public abstract void ordena();
    public abstract Integer getPrimeiro();
}

class FilaEncadeada extends Fila {
    private No inicio;
    private No fim;
    private int tamanhoAtual;

    public FilaEncadeada() {
        inicio = null;
        fim = null;
        tamanhoAtual = 0;
    }

    @Override
    public void enfileirar(Integer item) {
        No novo = new No(item);
        if (vazia()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
        tamanhoAtual++;
    }

    @Override
    public void desenfileirar() {
        if (!vazia()) {
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            tamanhoAtual--;
        } else {
            System.out.println("Fila vazia");
        }
    }

    @Override
    public boolean vazia() {
        return tamanhoAtual == 0;
    }

    @Override
    public int tamanhoFila() {
        return tamanhoAtual;
    }

    @Override
    public void ordena() {
        if (vazia()) return;

        No atual = inicio;
        while (atual != null) {
            No proximo = atual.proximo;
            while (proximo != null) {
                if (atual.valor > proximo.valor) {
                    int temp = atual.valor;
                    atual.valor = proximo.valor;
                    proximo.valor = temp;
                }
                proximo = proximo.proximo;
            }
            atual = atual.proximo;
        }
    }

    @Override
    public Integer getPrimeiro() {
        return inicio != null ? inicio.valor : null;
    }

    public void imprime() {
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaEncadeada fila = new FilaEncadeada();
        int[] vetorArmazena = new int[3];

        for (int i = 0; i < 3; i++) {
            int valor = sc.nextInt();
            fila.enfileirar(valor);
            vetorArmazena[i] = valor;
        }

        fila.ordena();
        fila.imprime();

        fila.desenfileirar();
        System.out.println("Primeiro elemento após desenfileirar: " + fila.getPrimeiro());
        
        sc.close();
    }
}