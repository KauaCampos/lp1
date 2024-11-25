package br.cefetmg.inf.llp.lista13.p1068_fila;

import java.util.Scanner;

interface Fila<T> {
    void enqueue(T valor) throws PosicaoInvalidaException;
    T dequeue() throws NenhumItemException;
    T peek() throws NenhumItemException;
    boolean isEmpty();
    int getSize();
    T[] toArray() throws NenhumItemException;
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

class FilaArray<T> implements Fila<T> {
    private T[] fila;
    private int frente;
    private int traseira;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaArray(int capacidade) {
        fila = (T[]) new Object[capacidade];
        frente = 0;
        traseira = -1;
        tamanho = 0;
    }

    @Override
    public void enqueue(T valor) throws PosicaoInvalidaException {
        if (tamanho == fila.length) {
            throw new PosicaoInvalidaException("Capacidade da fila excedida.");
        }
        traseira = (traseira + 1) % fila.length;
        fila[traseira] = valor;
        tamanho++;
    }

    @Override
    public T dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        T valor = fila[frente];
        frente = (frente + 1) % fila.length;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        return fila[frente];
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int getSize() {
        return tamanho;
    }

    @Override
    public T[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        T[] array = (T[]) new Object[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = fila[(frente + i) % fila.length];
        }
        return array;
    }
}

class FilaEncadeada<T> implements Fila<T> {
    private No<T> frente;
    private No<T> traseira;
    private int tamanho;

    public FilaEncadeada() {
        frente = null;
        traseira = null;
        tamanho = 0;
    }

    @Override
    public void enqueue(T valor) {
        No<T> novoNo = new No<>(valor);
        if (isEmpty()) {
            frente = novoNo;
            traseira = novoNo;
        } else {
            traseira.setProximo(novoNo);
            traseira = novoNo;
        }
        tamanho++;
    }

    @Override
    public T dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        T valor = frente.getValor();
        frente = frente.getProximo();
        if (frente == null) {
            traseira = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public T peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        return frente.getValor();
    }

    @Override
    public boolean isEmpty() {
        return frente == null;
    }

    @Override
    public int getSize() {
        return tamanho;
    }

    @Override
    public T[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[tamanho];
        No<T> atual = frente;
        int i = 0;

        while (atual != null) {
            array[i ++] = atual.getValor();
            atual = atual.getProximo();
        }
        return array;
    }
}

class FilaCircular<T> implements Fila<T> {
    private T[] fila;
    private int frente;
    private int traseira;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaCircular(int capacidade) {
        fila = (T[]) new Object[capacidade];
        frente = 0;
        traseira = -1;
        tamanho = 0;
    }

    @Override
    public void enqueue(T valor) throws PosicaoInvalidaException {
        if (tamanho == fila.length) {
            throw new PosicaoInvalidaException("Capacidade da fila excedida.");
        }
        traseira = (traseira + 1) % fila.length;
        fila[traseira] = valor;
        tamanho++;
    }

    @Override
    public T dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        T valor = fila[frente];
        frente = (frente + 1) % fila.length;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        return fila[frente];
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int getSize() {
        return tamanho;
    }

    @Override
    public T[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = fila[(frente + i) % fila.length];
        }
        return array;
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

            Fila<Character> fila = new FilaEncadeada<>();

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') {
                        fila.enqueue(ch);
                    } else if (ch == ')') {
                        if (!fila.isEmpty()) {
                            fila.dequeue();
                        } else {
                            cond = false;
                            break;
                        }
                    }
                }

                if (!fila.isEmpty()) {
                    cond = false;
                }

            } catch (NenhumItemException | PosicaoInvalidaException e) {
                cond = false;
            }

            if (cond) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

        sc.close();
    }
}