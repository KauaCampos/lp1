package br.cefetmg.inf.llp.lista12.p1068_pilha;

import java.util.Scanner;

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

class PilhaEncadeada {
    private No topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(Integer valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
        this.tamanho++;
    }

    public Integer pop() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        Integer valor = this.topo.getValor();
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return valor;
    }

    public Integer peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return this.topo.getValor();
    }

    public boolean isEmpty() {
        return this.topo == null;
    }

    public int getSize() {
        return this.tamanho;
    }
}

class PilhaArray {
    private Integer[] array;
    private int topo;

    public PilhaArray(int capacidade) {
        this.array = new Integer[capacidade];
        this.topo = -1;
    }

    public void push(Integer valor) throws PosicaoInvalidaException {
        if (topo == array.length - 1) {
            throw new PosicaoInvalidaException("Capacidade da pilha excedida.");
        }
        array[++topo] = valor;
    }

    public Integer pop() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return array[topo--];
    }

    public Integer peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return array[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int getSize() {
        return topo + 1;
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

            // Escolha de implementação de pilha:
            PilhaEncadeada pilha = new PilhaEncadeada(); // Usando PilhaEncadeada
            // PilhaArray pilha = new PilhaArray(1000); // Usando PilhaArray (com capacidade de 1000)

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') pilha.push((int) ch);
                    else if (ch == ')') {
                        if (!pilha.isEmpty()) pilha.pop();
                        else cond = false;
                    }
                }

                if (!pilha.isEmpty()) cond = false;

            } catch (NenhumItemException e) {
                cond = false;
            }

            if (cond) System.out.println("correct");
            else System.out.println("incorrect");
        }

        sc.close();
    }
}
