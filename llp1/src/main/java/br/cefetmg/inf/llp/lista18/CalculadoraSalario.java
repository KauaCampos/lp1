package br.cefetmg.inf.llp.lista18;

public class CalculadoraSalario {
    
    public static double calcularSalarioBruto(Funcionario f){
        
        double salarioBruto = 0.0;
        
        double horasSemExtra = f.getHorasTrabalhadas() - f.getHorasExtras();
        salarioBruto += 100.0 * horasSemExtra;
        salarioBruto += 50.0 * f.getHorasExtras();
        
        
        return salarioBruto;
    }
}
