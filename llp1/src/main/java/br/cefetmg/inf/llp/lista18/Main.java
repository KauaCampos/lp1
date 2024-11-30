package br.cefetmg.inf.llp.lista18;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args) throws CodigoInexistenteException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int quantFuncionarios = 0;

        // Lendo número de funcionários
        while (true) {
            try {
                quantFuncionarios = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar um número válido!");
                sc.nextLine();
            }
        }

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        // Entrada dos funcionários
        for (int contador = 0; contador < quantFuncionarios; contador++) {
            int auxCod;
            while (true) {
                try {
                    auxCod = sc.nextInt();
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

        // Lendo número de registros
        while (true) {
            try {
                quantRegistros = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar um número válido para registros!");
                sc.nextLine();
            }
        }

        // Processando registros
        for (int contador = 0; contador < quantRegistros; contador++) {

            String linhaEntrada = sc.nextLine();
            String[] partes = linhaEntrada.split(" ");

            if (partes.length != 3) {
                System.out.println("Entrada inválida! Certifique-se de usar o formato correto: data código horas.");
                contador--;
                continue;
            }

            String data = partes[0];
            int codigoFuncionario;
            double horasTrabalhadas;

            try {
                codigoFuncionario = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Código do funcionário inválido!");
                contador--;
                continue;
            }

            try {
                horasTrabalhadas = Double.parseDouble(partes[2]);
            } catch (NumberFormatException e) {
                System.out.println("Horas trabalhadas inválidas! Use ponto como separador decimal.");
                contador--;
                continue;
            }

            boolean codigoValido = false;
            int index = -1;
            for (int i = 0; i < listaFuncionarios.size(); i++) {
                if (listaFuncionarios.get(i).getCodigo() == codigoFuncionario) {
                    index = i;
                    codigoValido = true;
                    break;
                }
            }

            if (!codigoValido) {
                System.out.println("Código inexistente, tente novamente!");
                contador--;
                continue;
            }

            listaFuncionarios.get(index).setHorasTrabalhadas(horasTrabalhadas);
            if (horasTrabalhadas > 8.0) {
                listaFuncionarios.get(index).setHorasExtras(horasTrabalhadas - 8.0);
            }
        }

        // Calculando salários e exibindo
        for (Funcionario f : listaFuncionarios) {
            f.bruto.calcularSalarioBruto(f);
            f.liquido.setValor(f.bruto.getValor());
            f.liquido.calcularINSS();
            f.liquido.calcularIRPF();
            f.saidaDados();
        }

        sc.close();
    }
}
