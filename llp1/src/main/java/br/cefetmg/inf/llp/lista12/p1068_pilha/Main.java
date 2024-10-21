package br.cefetmg.inf.llp.lista12.p1068_pilha;

import java.util.Scanner;

interface Pilha {
    void push(Integer valor) throws PosicaoInvalidaException;
    Integer pop() throws NenhumItemException;
    Integer peek() throws NenhumItemException;
    boolean isEmpty();
    int getSize();
}

class NenhumItemException extends Exception {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
}

class PosicaoInvalidaException extends Exception {
    public PosicaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class PilhaEncadeada implements Pilha {
    private No topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(Integer valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
        this.tamanho++;
    }

    @Override
    public Integer pop() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        Integer valor = this.topo.getValor();
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return valor;
    }

    @Override
    public Integer peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return this.topo.getValor();
    }

    @Override
    public boolean isEmpty() {
        return this.topo == null;
    }

    @Override
    public int getSize() {
        return this.tamanho;
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

        String exp;
        boolean cond;

        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) break;

            cond = true;

            Pilha pilha = new PilhaEncadeada();

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') pilha.push((int) ch);
                    else if (ch == ')') {
                        if (!pilha.isEmpty()) pilha.pop();
                        else cond = false;
                    }
                }

                if (!pilha.isEmpty()) cond = false;

            } catch (NenhumItemException | PosicaoInvalidaException e) {
                cond = false;
            }

            if (cond) System.out.println("correct");
            else System.out.println("incorrect");
        }

        sc.close();
    }
}
