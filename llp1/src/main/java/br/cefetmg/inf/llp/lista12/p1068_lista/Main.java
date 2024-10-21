package br.cefetmg.inf.llp.lista12.p1068_lista;

import java.util.Scanner;

interface Lista {

    void inserirNoInicio(Integer valor);

    void inserirNoFim(Integer valor);

    void inserirNaPosicao(Integer valor, int posicao) throws PosicaoInvalidaException;

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

class ListaSimplesmenteEncadeada implements Lista {

    private No primeiroNo;
    private No ultimoNo;

    public ListaSimplesmenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    @Override
    public void inserirNoInicio(Integer valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(this.primeiroNo);
        this.primeiroNo = novoNo;
        if (this.ultimoNo == null) {
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirNoFim(Integer valor) {
        No novoNo = new No(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirNaPosicao(Integer valor, int posicao) throws PosicaoInvalidaException {
        if (posicao < 0 || posicao > getTamanho()) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }

        No novoNo = new No(valor);
        No atual = this.primeiroNo;
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
        No atual = this.primeiroNo;
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

    @Override
    public void imprimirLista() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A lista está vazia, nada para imprimir.");
        }

        No atual = this.primeiroNo;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
}

class ListaDuplamenteEncadeada implements Lista {

    private NoDuplo primeiroNo;
    private NoDuplo ultimoNo;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    @Override
    public void inserirNoInicio(Integer valor) {
        NoDuplo novoNo = new NoDuplo(valor);
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
    public void inserirNoFim(Integer valor) {
        NoDuplo novoNo = new NoDuplo(valor);
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
    public void inserirNaPosicao(Integer valor, int posicao) throws PosicaoInvalidaException {
        if (posicao < 0 || posicao > getTamanho()) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }

        NoDuplo novoNo = new NoDuplo(valor);
        NoDuplo atual = this.primeiroNo;
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

        NoDuplo atual = this.primeiroNo;
        NoDuplo proximo;

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

    @Override
    public int getTamanho() {
        int tamanho = 0;
        NoDuplo atual = this.primeiroNo;
        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }
        return tamanho;
    }

    @Override
    public void imprimirLista() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A lista está vazia, nada para imprimir.");
        }

        NoDuplo atual = this.primeiroNo;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
}

class NoDuplo {

    private Integer valor;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Integer valor) {
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

    public NoDuplo getProximo() {
        return this.proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
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

            // Lista lista = new ListaSimplesmenteEncadeada();
            Lista lista = new ListaDuplamenteEncadeada();

            for (char ch : exp.toCharArray()) {
                if (ch == '(') {
                    lista.inserirNoFim((int) ch);
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
