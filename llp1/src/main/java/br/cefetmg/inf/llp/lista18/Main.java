package br.cefetmg.inf.llp.lista18;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args) throws CodigoInexistenteException {
        Scanner sc = new Scanner(System.in);

        int quantFuncionarios = 0;

        while (true) {
            try {
                quantFuncionarios = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar o número de funcionários!");
                sc.nextLine();
            }
        }

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        for (int contador = 0; contador < quantFuncionarios; contador++) {
            int auxCod;
            while (true) {
                try {
                    auxCod = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Você deve digitar um código válido!");
                    sc.nextLine();
                }
            }

            String auxNome = sc.nextLine();
            Funcionario auxFun = new Funcionario(auxNome, auxCod);
            listaFuncionarios.add(auxFun);
        }

        int quantRegistros = 0;
        while (true) {
            try {
                quantRegistros = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar o número de registros!");
                sc.nextLine();
            }
        }

        for (int contador = 0; contador < quantRegistros; contador++) {
            sc.next();
            boolean codigoValido = false;
            int index = -1;
            
            while (!codigoValido) {
                int codigoFuncionario;
                while (true) {
                    try {
                        codigoFuncionario = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Você deve digitar um código de funcionário válido!");
                        sc.nextLine();
                    }
                }
                
                for (int i = 0; i < listaFuncionarios.size(); i++){
                    if (listaFuncionarios.get(i).getCodigo() == codigoFuncionario) {
                        index = i;
                        codigoValido = true;
                    }
                }
                
                if (index == -1) {
                    throw new CodigoInexistenteException("Codigo nao existente, insira um novo!");
                }
            }
            
            double horasTrabalhadas = sc.nextDouble();
            listaFuncionarios.get(index).setHorasTrabalhadas(horasTrabalhadas);
            
            if (horasTrabalhadas > 8.0)
                listaFuncionarios.get(index).setHorasExtras(horasTrabalhadas - 8.0);
        }
               
        

        sc.close();
    }
}
