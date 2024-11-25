package br.cefetmg.inf.llp.lista13.p1068_lista;

import java.util.Scanner;

interface Lista<T> {
    void inserirNoInicio(T valor);
    void inserirNoFim(T valor);
    void inserirNaPosicao(T valor, int posicao) throws PosicaoInvalidaException;
    void ordenar() throws NenhumItemException;
    void imprimirLista() throws NenhumItemException;
    int getTamanho();
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

class ListaSimplesmenteEncadeada<T> implements Lista<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;

    public ListaSimplesmenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    @Override
    public void inserirNoInicio(T valor) {
        No<T> novoNo = new No<>(valor);
        novoNo.setProximo(this.primeiroNo);
        this.primeiroNo = novoNo;
        if (this.ultimoNo == null) {
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirNoFim(T valor) {
        No<T> novoNo = new No<>(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirNaPosicao(T valor, int posicao) throws PosicaoInvalidaException {
        if (posicao < 0 || posicao > getTamanho()) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }

        No<T> novoNo = new No<>(valor);
        No<T> atual = this.primeiroNo;
        int contador = 0;

        while (contador < posicao - 1) {
            atual = atual.getProximo();
            contador++;
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);

        if (novoNo.getProximo() == null) {
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public int getTamanho() {
        int tamanho = 0;
        No<T> atual = this.primeiroNo;
        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }
        return tamanho;
    }

    @Override
    public void ordenar() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A lista está vazia, não pode ser ordenada.");
        }

        No<T> atual = this.primeiroNo;
        No<T> proximo;

        while (atual != null) {
            proximo = atual.getProximo();
            while (proximo != null) {
                if ((Integer) atual.getValor() > (Integer) proximo.getValor()) {
                    T temp = atual.getValor();
                    atual.setValor(proximo.getValor());
                    proximo.setValor(temp);
                }
                proximo = proximo.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    @Override
    public void imprimirLista() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A lista está vazia, nada para imprimir.");
        }

        No<T> atual = this.primeiroNo;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
}

class NoDuplo<T> {
    private T valor;
    private NoDuplo<T> proximo;
    private NoDuplo<T> anterior;

    public NoDuplo(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDuplo<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    public NoDuplo<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }
}

class ListaDuplamenteEncadeada<T> implements Lista<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    @Override
    public void inserirNoInicio(T valor) {
        NoDuplo<T> novoNo = new NoDuplo<>(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo.setAnterior(novoNo);
            this.primeiroNo = novoNo;
        }
    }

    @Override
    public void inserirNoFim(T valor) {
        NoDuplo<T> novoNo = new NoDuplo<>(valor);
        if (this.ultimoNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirNaPosicao(T valor, int posicao) throws PosicaoInvalidaException {
        if (posicao < 0 || posicao > getTamanho()) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }

        NoDuplo<T> novoNo = new NoDuplo<>(valor);
        NoDuplo<T> atual = this.primeiroNo;
        int contador = 0;

        while (contador < posicao - 1) {
            atual = atual.getProximo();
            contador++;
        }

        novoNo.setProximo(atual.getProximo());
        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(novoNo);
        }
        atual.setProximo(novoNo);
        novoNo.setAnterior(atual);

        if (novoNo.getProximo() == null) {
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void ordenar() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A lista está vazia, não pode ser ordenada.");
        }

        NoDuplo<T> atual = this.primeiroNo;
        NoDuplo<T> proximo;

        while (atual != null) {
            proximo = atual.getProximo();
            while (proximo != null) {
                if ((Integer) atual.getValor() > (Integer) proximo.getValor()) {
                    T temp = atual.getValor();
                    atual.setValor(proximo.getValor());
                    proximo.setValor(temp);
                }
                proximo = proximo.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    @Override
    public int getTamanho() {
        int tamanho = 0;
        NoDuplo<T> atual = this.primeiroNo;
        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }
        return tamanho;
    }

    @Override
    public void imprimirLista() throws NenhumItemException {
        NoDuplo<T> atual = this.primeiroNo;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
}

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        String exp;
        boolean cond;

        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) {
                break;
            }

            cond = true;

            Lista<Character> lista = new ListaDuplamenteEncadeada<>();

            for (char ch : exp.toCharArray()) {
                if (ch == '(') {
                    lista.inserirNoFim(ch);
                } else if (ch == ')') {
                    if (lista.getTamanho() > 0) {
                        lista.inserirNoFim(null); // Remover o último
                    } else {
                        cond = false;
                    }
                }
            }

            if (lista.getTamanho() > 0) {
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