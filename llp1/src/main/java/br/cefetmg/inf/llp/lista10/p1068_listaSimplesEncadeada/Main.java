package br.cefetmg.inf.llp.lista10.p1068_listaSimplesEncadeada;

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
            ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();

            for (char ch : exp.toCharArray()) {
                if (ch == '(') lista.inserirNoFim((int) ch);

                else if (ch == ')') {
                    if (!lista.isEmpty()) {
                        No ultimoNo = lista.removerUltimoNo();
                        if (ultimoNo.getValor() != (int) '(') {
                            cond = false;
                            break;
                        }
                    } 
                    
                    else {
                        cond = false;
                        break;
                    }
                }
            }

            if (!lista.isEmpty()) cond = false;

            while (!lista.isEmpty()) {
                No no = lista.removerUltimoNo();
                if (no.getValor() == (int) '(') {
                    aberto++;
                } 
                
                else if (no.getValor() == (int) ')') {
                    fechado++;
                }
            }

            if (aberto != fechado) cond = false;

            if (cond) System.out.println("correct");
            else System.out.println("incorrect");
        }

        sc.close();
    }
}

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

    public No getPrimeiroNo() {
        return primeiroNo;
    }

    public boolean isEmpty() {
        return this.primeiroNo == null;
    }

    public No removerUltimoNo() {
        if (this.primeiroNo == null) {
            return null;
        }
        if (this.primeiroNo == this.ultimoNo) {
            No no = this.primeiroNo;
            this.primeiroNo = null;
            this.ultimoNo = null;
            return no;
        }
        No atual = this.primeiroNo;
        while (atual.getProximo() != this.ultimoNo) {
            atual = atual.getProximo();
        }
        No no = this.ultimoNo;
        this.ultimoNo = atual;
        this.ultimoNo.setProximo(null);
        return no;
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