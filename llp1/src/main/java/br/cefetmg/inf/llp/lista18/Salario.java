package br.cefetmg.inf.llp.lista18;

public class Salario {

    private Double valor;
    private Double valorExtra;

    public Salario() {
        this.valor = 0.0;
        this.valorExtra = 0.0;
    }

    public Double getValor() {
        return valor;
    }

    public Double getValorExtra() {
        return valorExtra;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValorExtra(Double valorExtra) {
        this.valorExtra = valorExtra;
    }

    public void calcularSalarioBruto(Funcionario f) {
        double horasSemExtra = f.getHorasTrabalhadas() - f.getHorasExtras();
        this.valor = 100.0 * horasSemExtra; 
        this.valorExtra = 150.0 * f.getHorasExtras();
        this.valor += this.valorExtra;
    }

}
