package br.cefetmg.inf.llp.lista10.p1042_listaDuplaEncadeada;

import java.util.Scanner;

class ListaDuplamenteEncadeada {

    private No primeiroNo;
    private No ultimoNo;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void inserirNoInicio(Integer valor) {
        No novoNo = new No(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } 
        
        else {
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo.setAnterior(novoNo);
            this.primeiroNo = novoNo;
        }
    }

    public void inserirNoFim(Integer valor) {
        No novoNo = new No(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } 
        
        else {
            this.ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
    }

    public void ordenar() {
        if (this.primeiroNo == null) {
            return;
        }

        No atual = this.primeiroNo;
        No proximo;

        while (atual != null) {
            proximo = atual.getProximo();
            while (proximo != null) {
                if (atual.getValor() > proximo.getValor()) {
                    Integer temp = atual.getValor();
                    atual.setValor(proximo.getValor());
                    proximo.setValor(temp);
                }
                proximo = proximo.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    public No getPrimeiroNo() {
        return primeiroNo;
    }

    public void imprimirLista() {
        No atual = this.primeiroNo;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
}

class No {

    private Integer valor;
    private No proximo;
    private No anterior;

    public No(Integer valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return this.anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        int aux;

        for (int i = 0; i < 3; i++) {
            aux = sc.nextInt();
            lista.inserirNoFim(aux);
        }

        ListaDuplamenteEncadeada listaOrdenada = new ListaDuplamenteEncadeada();
        No atual = lista.getPrimeiroNo();

        while (atual != null) {
            listaOrdenada.inserirNoFim(atual.getValor());
            atual = atual.getProximo();
        }

        listaOrdenada.ordenar();
        listaOrdenada.imprimirLista();
        System.out.println();
        lista.imprimirLista();

        sc.close();
    }
}
