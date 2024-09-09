package br.cefetmg.inf.llp.lista10.p1068_listaDuplaEncadeada;

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
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

            for (char ch : exp.toCharArray()) {
                if (ch == '(') lista.inserirNoFim((int) ch);

                else if (ch == ')') {
                    if (lista.getPrimeiroNo() != null) {
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

            if (lista.getPrimeiroNo() != null) cond = false;

            while (lista.getPrimeiroNo() != null) {
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

class ListaDuplamenteEncadeada {

    private No primeiroNo;
    private No ultimoNo;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
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

    public No getPrimeiroNo() {
        return primeiroNo;
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
        No no = this.ultimoNo;
        this.ultimoNo = this.ultimoNo.getAnterior();
        this.ultimoNo.setProximo(null);
        return no;
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