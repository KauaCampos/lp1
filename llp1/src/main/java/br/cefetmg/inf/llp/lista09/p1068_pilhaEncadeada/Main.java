package br.cefetmg.inf.llp.lista09.p1068_pilhaEncadeada;

import java.util.Scanner;

class No {
    char valor;
    No proximo;

    public No(char valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class PilhaEncadeada {
    private No topo;

    public PilhaEncadeada() {
        topo = null;
    }

    public void push(char valor) {
        No novoNo = new No(valor);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public void pop() {
        if (topo != null) {
            topo = topo.proximo;
        }
    }

    public char peek() {
        return topo.valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        int tamanho = 0;
        No atual = topo;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }
}

public class Main {
    
    public static void main (String[] Args) {
        Scanner sc = new Scanner(System.in);
        
        String exp;
        boolean cond;
        int aberto, fechado;
        
        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) break;
            aberto = 0; fechado = 0;
            
            cond = true;
            PilhaEncadeada pilha = new PilhaEncadeada();
            
            for (char ch : exp.toCharArray()) {
                if (ch == '(') pilha.push(ch);
                
                else if (ch == ')') {
                    if (!pilha.isEmpty()) pilha.push(ch);                   
                    else cond = false;
                }
            }
            
            if (!pilha.isEmpty() && pilha.peek() == '(') cond = false;
            
            while (!pilha.isEmpty() && cond) {
                if (pilha.peek() == '(') {
                    aberto++;
                    pilha.pop();
                }
                
                else if (pilha.peek() == ')'){
                    fechado++;
                    pilha.pop();
                }
            }
            
            if (aberto != fechado) cond = false;
            
            if (cond) System.out.println("correct");
            else System.out.println("incorrect");
            
        }
        
        sc.close();
    }
}