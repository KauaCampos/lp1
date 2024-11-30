package br.cefetmg.inf.llp.lista18;

public class Funcionario {

    private final String nome;
    public Salario bruto;
    public SalarioLiquido liquido;
    private final Integer codigo;
    private Double horasTrabalhadas;
    private Double horasExtras;

    public Funcionario(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.horasTrabalhadas = 0.0;
        this.horasExtras = 0.0;
        bruto = new Salario();
        liquido = new SalarioLiquido();
    }

    public String getNome() {
        return nome;
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

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas += horasTrabalhadas;
    }

    public void setHorasExtras(Double horasExtras) {
        this.horasExtras += horasExtras;
    }

    public void saidaDados() {
        this.liquido.calcularINSS();
        System.out.print(codigo + " " + nome + " ");
        System.out.printf("%.1f %.1f %.2f %.2f ", getHorasTrabalhadas(), getHorasExtras(),
                bruto.getValorExtra(), bruto.getValor());
        System.out.printf("%.1f%% %.2f %.2f ", liquido.getAliquotaINSS(), liquido.getValorDescontadoINSS(),
                liquido.getValorLiquidoAposINSS());
        System.out.printf("%.1f%% %.2f %.2f %.2f", liquido.getAliquotaIRPF(), 
                liquido.getValorDescontadoIRPF(), liquido.getDeducaoMaisINSS(), liquido.getValorLiquido());
        System.out.println();
    }

}
