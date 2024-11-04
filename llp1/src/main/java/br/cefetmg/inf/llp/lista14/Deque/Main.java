package br.cefetmg.inf.llp.lista14.Deque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] Args) throws NenhumItemException {
        
        Scanner sc = new Scanner (System.in);
        
        int escolha;
        boolean continuar = false;
        Integer elemento;
        
        System.out.println("--- Deseja criar um Deque? ---");
        System.out.println("--- 1-Sim  / 2-Nao ---");
        
        try {
            escolha = sc.nextInt();
            if (escolha == 1) continuar = true;
            
            System.out.println("--- Deque criado ---");
            System.out.println("");
        } 
        
        catch (InputMismatchException e) {
            System.out.println("*** Tipo Incompativel ***");
            
        }
        
        Deque<Integer> deque = new Deque<>();
        while (continuar) {
            
            System.out.println("--- Selecione uma opção ---");
            System.out.println("--- 1- Verificar Tamanho ---");
            System.out.println("--- 2- Verificar Se Esta Vazio ---");
            System.out.println("--- 3- Inserir Elemento No Inicio ---");
            System.out.println("--- 4- Inserir Elemento No Final ---");
            System.out.println("--- 5- Remover Elemento No Inicio ---");
            System.out.println("--- 6- Remover Elemento no Final ---");
            System.out.println("--- 7- Imprimir Deque ---");
            System.out.println("--- 0- Encerrar ---");
            System.out.println("");
            
            try {
                escolha = sc.nextInt();
                
                switch (escolha) {
                    case 1: System.out.println("O tamanho do deque e: " + deque.getTamanho());
                            break;
                            
                    case 2: if (deque.estaVazio()) 
                                System.out.println("O deque esta vazio.");
                            else 
                                System.out.println("O deque nao esta vazio.");
                            break;
                            
                    case 3: System.out.println("--- Insira o Elemento ---");
                            elemento = sc.nextInt();
                            deque.inserirNoInicio(elemento);
                            System.out.println(elemento + " foi inserido no inicio do deque.");
                            break;
                            
                    case 4: System.out.println("--- Insira o Elemento ---");
                            elemento = sc.nextInt();
                            deque.inserirNoFim(elemento);
                            System.out.println(elemento + " foi inserido no final do deque.");
                            break;
                            
                    case 5: System.out.println("O primeiro elemento (" + deque.removerPrimeiro() + ") foi removido.");
                            break;
                            
                    case 6: System.out.println("O ultimo elemento (" + deque.removerUltimo() + ") foi removido.");
                            break;
                            
                    case 7: deque.imprimirDeque();
                            break;
                            
                    default: continuar = false;
                }
                
                System.out.println("");
            } 
        
            catch (InputMismatchException e) {
                System.out.println("*** Tipo Incompativel ***");
                continuar = false;
            }
            
        }
        
        System.out.println("--- Encerrado ---");
    }
}
