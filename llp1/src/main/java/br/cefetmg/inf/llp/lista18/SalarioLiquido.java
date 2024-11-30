package br.cefetmg.inf.llp.lista18;

public class SalarioLiquido extends Salario {

    private Double valorLiquido;
    private Double valorLiquidoAposINSS;
    private Double aliquotaINSS;
    private Double aliquotaIRPF;
    private Double valorDescontadoINSS;
    private Double valorDescontadoIRPF;
    private Double deducaoIRPF;
    private Double deducaoMaisINSS;

    public SalarioLiquido() {
        super();
        this.valorLiquido = 0.0;
        this.deducaoMaisINSS = 0.0;
    }

    public void calcularINSS() {
        if (getValor() <= 1212.00) {
            this.aliquotaINSS = 7.5;
        } else if (getValor() <= 2427.35) {
            this.aliquotaINSS = 9.0;
        } else if (getValor() <= 3641.03) {
            this.aliquotaINSS = 12.0;
        } else {
            this.aliquotaINSS = 14.0;
        }
        this.valorDescontadoINSS = getValor() * (this.aliquotaINSS / 100);
        this.valorLiquidoAposINSS = getValor() - this.valorDescontadoINSS;
    }

    public void calcularIRPF() {
        if (valorLiquidoAposINSS <= 1903.98) {
            this.aliquotaIRPF = 0.0;
            this.deducaoIRPF = 0.0;
        } else if (valorLiquidoAposINSS <= 2826.65) {
            this.aliquotaIRPF = 7.5;
            this.deducaoIRPF = 142.80;
        } else if (valorLiquidoAposINSS <= 3751.05) {
            this.aliquotaIRPF = 15.0;
            this.deducaoIRPF = 354.80;
        } else if (valorLiquidoAposINSS <= 4664.68) {
            this.aliquotaIRPF = 22.5;
            this.deducaoIRPF = 636.13;
        } else {
            this.aliquotaIRPF = 27.5;
            this.deducaoIRPF = 869.36;
        }
        
        this.valorDescontadoIRPF = (valorLiquidoAposINSS * (aliquotaIRPF / 100)) - deducaoIRPF;
        this.deducaoMaisINSS = valorDescontadoINSS + valorDescontadoIRPF;
        this.valorLiquido = valorLiquidoAposINSS - valorDescontadoIRPF;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public Double getAliquotaINSS() {
        return aliquotaINSS;
    }

    public Double getAliquotaIRPF() {
        return aliquotaIRPF;
    }

    public Double getValorDescontadoINSS() {
        return valorDescontadoINSS;
    }

    public Double getValorDescontadoIRPF() {
        return valorDescontadoIRPF;
    }

    public Double getDeducaoMaisINSS() {
        return deducaoMaisINSS;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Double getValorLiquidoAposINSS() {
        return valorLiquidoAposINSS;
    }

    public Double getDeducaoIRPF() {
        return deducaoIRPF;
    }

}
