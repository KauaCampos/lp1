package br.cefetmg.inf.llp.lista10.p1068_listaArray;

import java.util.Scanner;

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        String exp;
        boolean cond;
        int aberto, fechado;

        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) break;
            aberto = 0; fechado = 0;

            cond = true;
            ListaComArray lista = new ListaComArray(2);

            for (char ch : exp.toCharArray()) {
                if (ch == '(') lista.inserirNoFim((int) ch);

                else if (ch == ')') {
                    if (lista.getTamanho() > 0 && lista.getElemento(lista.getTamanho() - 1) == '(') {
                        lista.setTamanho(lista.getTamanho() - 1);
                    } else cond = false;
                }
            }

            if (lista.getTamanho() > 0) cond = false;

            while (lista.getTamanho() > 0) {
                if (lista.getElemento(lista.getTamanho() - 1) == '(') {
                    aberto++;
                    lista.setTamanho(lista.getTamanho() - 1);
                } else if (lista.getElemento(lista.getTamanho() - 1) == ')') {
                    fechado++;
                    lista.setTamanho(lista.getTamanho() - 1);
                }
            }

            if (aberto != fechado) cond = false;

            if (cond) System.out.println("correct");
            else System.out.println("incorrect");
        }

        sc.close();
    }
}

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
    
    public void setTamanho(int novoTamanho) {
        this.tamanho = novoTamanho;
    }
}