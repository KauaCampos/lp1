package br.cefetmg.inf.llp.lista12.p1042_pilha;

import java.util.Scanner;

interface Pilha {
    void push(Integer valor);
    Integer pop() throws NenhumItemException;
    Integer peek() throws NenhumItemException;
    boolean isEmpty();
    int getSize();
    Integer[] toArray() throws NenhumItemException;
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

    @Override
    public Integer[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        
        Integer[] array = new Integer[tamanho];
        No atual = this.topo;
        int i = 0;
        
        while (atual != null) {
            array[i++] = atual.getValor();
            atual = atual.getProximo();
        }
        
        return array;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pilha pilha = new PilhaEncadeada();

        Integer[] original = new Integer[3];
        for (int i = 0; i < 3; i++) {
            original[i] = sc.nextInt();
            pilha.push(original[i]);
        }

        try {
            Integer[] pilhaArray = pilha.toArray();
            Integer[] ordenado = new Integer[3];
            
            for (int i = 0; i < 3; i++) {
                ordenado[i] = pilhaArray[i];
            }

            for (int i = 0; i < ordenado.length - 1; i++) {
                for (int j = 0; j < ordenado.length - i - 1; j++) {
                    if (ordenado[j] > ordenado[j + 1]) {
                        int temp = ordenado[j];
                        ordenado[j] = ordenado[j + 1];
                        ordenado[j + 1] = temp;
                    }
                }
            }

            for (int valor : ordenado) {
                System.out.println(valor);
            }

            System.out.println();

            for (int valor : original) {
                System.out.println(valor);
            }

        } catch (NenhumItemException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
