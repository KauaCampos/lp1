package br.cefetmg.inf.llp.lista14.Deque;

public class No<T> {

    private T valor;
    private No proximo;
    private No anterior;

    public No(T valor) {
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
