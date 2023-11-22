package model;

import java.util.Date;
import java.util.List;

public class Veiculo {
    
    private Date anoFabricacao;
    private List<Pessoa> pessoas;
    private String tipoVeiculo;
    private double qtCarga;

    public Veiculo() {
    }
    
    public Veiculo(Date anoFabricacao, List<Pessoa> pessoas, String tipoVeiculo, double qtCarga) {
        this.anoFabricacao = anoFabricacao;
        this.pessoas = pessoas;
        this.tipoVeiculo = tipoVeiculo;
        this.qtCarga = qtCarga;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public double getQtCarga() {
        return qtCarga;
    }

    public void setQtCarga(double qtCarga) {
        this.qtCarga = qtCarga;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
        result = prime * result + ((pessoas == null) ? 0 : pessoas.hashCode());
        result = prime * result + ((tipoVeiculo == null) ? 0 : tipoVeiculo.hashCode());
        long temp;
        temp = Double.doubleToLongBits(qtCarga);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veiculo other = (Veiculo) obj;
        if (anoFabricacao == null) {
            if (other.anoFabricacao != null)
                return false;
        } else if (!anoFabricacao.equals(other.anoFabricacao))
            return false;
        if (pessoas == null) {
            if (other.pessoas != null)
                return false;
        } else if (!pessoas.equals(other.pessoas))
            return false;
        if (tipoVeiculo == null) {
            if (other.tipoVeiculo != null)
                return false;
        } else if (!tipoVeiculo.equals(other.tipoVeiculo))
            return false;
        if (Double.doubleToLongBits(qtCarga) != Double.doubleToLongBits(other.qtCarga))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo [anoFabricacao=" + anoFabricacao + ", pessoas=" + pessoas + ", tipoVeiculo=" + tipoVeiculo
                + ", qtCarga=" + qtCarga + "]";
    }

    public static boolean validarTipoVeiculo(String tipoVeiculo){
        return "C".equals(tipoVeiculo) || 
               "CM".equals(tipoVeiculo) || 
               "B".equals(tipoVeiculo);
    }
    
}
