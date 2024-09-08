package br.cefetmg.inf.llp.lista10.p1042_listaArray;

import java.util.Scanner;

class ListaComArray {

    private Integer[] elementos;
    private int tamanho;

    public ListaComArray(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.tamanho = 0;
    }

    public void inserirNoInicio(Integer valor) {
        if (this.tamanho == this.elementos.length) {
            redimensionar();
        }
        for (int i = this.tamanho; i > 0; i--) {
            this.elementos[i] = this.elementos[i - 1];
        }
        this.elementos[0] = valor;
        this.tamanho++;
    }

    public void inserirNoFim(Integer valor) {
        if (this.tamanho == this.elementos.length) {
            redimensionar();
        }
        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    public void ordenar() {
        for (int i = 0; i < this.tamanho - 1; i++) {
            for (int j = i + 1; j < this.tamanho; j++) {
                if (this.elementos[i] > this.elementos[j]) {
                    Integer temp = this.elementos[i];
                    this.elementos[i] = this.elementos[j];
                    this.elementos[j] = temp;
                }
            }
        }
    }

    public void imprimirLista() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.elementos[i]);
        }
    }

    private void redimensionar() {
        Integer[] novoArray = new Integer[this.elementos.length * 2];
        for (int i = 0; i < this.elementos.length; i++) {
            novoArray[i] = this.elementos[i];
        }
        this.elementos = novoArray;
    }

    public Integer getElemento(int i) {
        return elementos [i];
    }

    public int getTamanho() {
        return tamanho;
    }
    
}

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        ListaComArray lista = new ListaComArray(3);
        int aux;

        for (int i = 0; i < 3; i++) {
            aux = sc.nextInt();
            lista.inserirNoFim(aux);
        }

        ListaComArray listaOrdenada = new ListaComArray(3);
        for (int i = 0; i < lista.getTamanho(); i++) {
            listaOrdenada.inserirNoFim(lista.getElemento(i));
        }

        listaOrdenada.ordenar();
        listaOrdenada.imprimirLista();
        System.out.println();
        lista.imprimirLista();

        sc.close();
    }
}
