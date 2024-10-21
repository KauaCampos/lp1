package br.cefetmg.inf.llp.lista12.p1068_fila;

import java.util.Scanner;

interface Fila {
    void enqueue(Integer valor) throws PosicaoInvalidaException;
    Integer dequeue() throws NenhumItemException;
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

class FilaArray implements Fila {
    private Integer[] fila;
    private int frente;
    private int traseira;
    private int tamanho;

    public FilaArray(int capacidade) {
        fila = new Integer[capacidade];
        frente = 0;
        traseira = -1;
        tamanho = 0;
    }

    @Override
    public void enqueue(Integer valor) throws PosicaoInvalidaException {
        if (tamanho == fila.length) {
            throw new PosicaoInvalidaException("Capacidade da fila excedida.");
        }
        traseira = (traseira + 1) % fila.length;
        fila[traseira] = valor;
        tamanho++;
    }

    @Override
    public Integer dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        Integer valor = fila[frente];
        frente = (frente + 1) % fila.length;
        tamanho--;
        return valor;
    }

    @Override
    public Integer peek() throws NenhumItemException {
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
    public Integer[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        Integer[] array = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = fila[(frente + i) % fila.length];
        }
        return array;
    }
}

class FilaEncadeada implements Fila {
    private No frente;
    private No traseira;
    private int tamanho;

    public FilaEncadeada() {
        frente = null;
        traseira = null;
        tamanho = 0;
    }

    @Override
    public void enqueue(Integer valor) {
        No novoNo = new No(valor);
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
    public Integer dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        Integer valor = frente.getValor();
        frente = frente.getProximo();
        if (frente == null) {
            traseira = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public Integer peek() throws NenhumItemException {
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
    public Integer[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        Integer[] array = new Integer[tamanho];
        No atual = frente;
        int i = 0;

        while (atual != null) {
            array[i++] = atual.getValor();
            atual = atual.getProximo();
        }
        return array;
    }
}

class FilaCircular implements Fila {
    private Integer[] fila;
    private int frente;
    private int traseira;
    private int tamanho;

    public FilaCircular(int capacidade) {
        fila = new Integer[capacidade];
        frente = 0;
        traseira = -1;
        tamanho = 0;
    }

    @Override
    public void enqueue(Integer valor) throws PosicaoInvalidaException {
        if (tamanho == fila.length) {
            throw new PosicaoInvalidaException("Capacidade da fila excedida.");
        }
        traseira = (traseira + 1) % fila.length;
        fila[traseira] = valor;
        tamanho++;
    }

    @Override
    public Integer dequeue() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }
        Integer valor = fila[frente];
        frente = (frente + 1) % fila.length;
        tamanho--;
        return valor;
    }

    @Override
    public Integer peek() throws NenhumItemException {
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
    public Integer[] toArray() throws NenhumItemException {
        if (isEmpty()) {
            throw new NenhumItemException("A fila está vazia.");
        }

        Integer[] array = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = fila[(frente + i) % fila.length];
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

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        String exp;
        boolean cond;

        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) break;

            cond = true;

            Fila fila = new FilaEncadeada();

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') {
                        fila.enqueue((int) ch);
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
