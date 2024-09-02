package br.cefetmg.inf.llp.lista10.p1042_listaSimplesEncadeada;

import java.util.Scanner;

class ListaSimplesmenteEncadeada {

    private No primeiroNo;
    private No ultimoNo;

    public ListaSimplesmenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void inserirNoInicio(Integer valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(this.primeiroNo);
        this.primeiroNo = novoNo;
        if (this.ultimoNo == null) {
            this.ultimoNo = novoNo;
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

    public No(Integer valor) {
        this.valor = valor;
        this.proximo = null;
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
}

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();
        int aux;

        for (int i = 0; i < 3; i++) {
            aux = sc.nextInt();
            lista.inserirNoFim(aux);
        }

        ListaSimplesmenteEncadeada listaOrdenada = new ListaSimplesmenteEncadeada();
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
