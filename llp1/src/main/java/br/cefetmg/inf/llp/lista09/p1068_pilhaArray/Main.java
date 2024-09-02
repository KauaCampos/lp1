package br.cefetmg.inf.llp.lista09.p1068_pilhaArray;

import java.util.Scanner;

class PilhaArray {
    private char[] stack;
    private int top;

    public PilhaArray() {
        stack = new char[2];
        top = -1;
    }

    public void push(char value) {
        if (top == stack.length - 1) {
            resizeArray(2 * stack.length);
        }
        stack[++top] = value;
    }

    public void pop() {
        top--;
        
        if (top > 0 && top == stack.length / 4) {
            resizeArray(stack.length / 2);
        }
    }

    public char peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resizeArray(int newCapacity) {
        char[] newStack = new char[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
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
            PilhaArray pilha = new PilhaArray();
            
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
