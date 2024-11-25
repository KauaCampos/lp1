package br.cefetmg.inf.llp.lista13.p1068_pilha;

import java.util.Scanner;

interface Pilha<T> {
    void push(T valor) throws PosicaoInvalidaException;
    T pop() throws NenhumItemException;
    T peek() throws NenhumItemException;
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

class PilhaEncadeada<T> implements Pilha<T> {
    private No<T> topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(T valor) {
        No<T> novoNo = new No<>(valor);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
        this.tamanho++;
    }

    @Override
    public T pop() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        T valor = this.topo.getValor();
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return valor;
    }

    @Override
    public T peek() throws NenhumItemException {
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

class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(No<T> proximo) {
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

            Pilha<Character> pilha = new PilhaEncadeada<>();

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') pilha.push(ch);
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