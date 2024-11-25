package br.cefetmg.inf.llp.lista18;

public class Funcionario {
    
    private final String nome;
    private Double salarioBruto;
    private Double salarioLiquido;
    private final Integer codigo;
    private Double horasTrabalhadas;
    private Double horasExtras;

    public Funcionario(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.horasTrabalhadas = 0.0;
        this.horasExtras = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public Double getHorasExtras() {
        return horasExtras;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas += horasTrabalhadas;
    }

    public void setHorasExtras(Double horasExtras) {
        this.horasExtras += horasExtras;
    }

    @Override
    public String toString() {
        return "Funcionario{" + '}';
    }
    
}
