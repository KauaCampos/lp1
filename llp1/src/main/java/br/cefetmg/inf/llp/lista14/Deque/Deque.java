package br.cefetmg.inf.llp.lista14.Deque;

class NenhumItemException extends Exception {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
}

public class Deque<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public Deque() {
        primeiroNo = null;
        ultimoNo = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public boolean estaVazio() {
        return tamanho == 0;
    }

    public void inserirNoFim(T valor) {
        No<T> novoNo = new No<>(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } 
        
        else {
            this.ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
        tamanho++;
    }

    public T removerUltimo() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A fila está vazia");
        }
        
        T valorRemovido = ultimoNo.getValor();

        if (this.primeiroNo == this.ultimoNo) {
            this.primeiroNo = null;
            this.ultimoNo = null;
        } 
        
        else {
            this.ultimoNo = this.ultimoNo.getAnterior();
            this.ultimoNo.setProximo(null);
        }

        tamanho--;
        return valorRemovido;
    }
    
    public void inserirNoInicio(T valor) {
        No<T> novoNo = new No<>(valor);
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } 
        
        else {
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo.setAnterior(novoNo);
            this.primeiroNo = novoNo;
        }
        tamanho++;
    }

    public T removerPrimeiro() throws NenhumItemException {
        if (this.primeiroNo == null) {
            throw new NenhumItemException("A fila está vazia");
        }
        
        T valorRemovido = primeiroNo.getValor();
        if (this.primeiroNo == this.ultimoNo) {
            this.primeiroNo = null;
            this.ultimoNo = null;
        } 
        
        else {
            this.primeiroNo = this.primeiroNo.getProximo();
            this.primeiroNo.setAnterior(null);
        }

        tamanho--;
        return valorRemovido;
    }
    
    public void imprimirDeque() throws NenhumItemException {
        if (primeiroNo == null) {
            throw new NenhumItemException("A fila esta vazia");
        }

        No<T> atual = primeiroNo;
        System.out.print("Deque: ");
        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}