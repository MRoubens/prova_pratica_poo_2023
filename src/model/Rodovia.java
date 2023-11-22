package model;

public class Rodovia {
    
    private String sigla;
    private String periculosidade;

    public Rodovia() {
    }

    public Rodovia(String sigla, String periculosidade) {
        this.sigla = sigla;
        this.periculosidade = periculosidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(String periculosidade) {
        this.periculosidade = periculosidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
        result = prime * result + ((periculosidade == null) ? 0 : periculosidade.hashCode());
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
        Rodovia other = (Rodovia) obj;
        if (sigla == null) {
            if (other.sigla != null)
                return false;
        } else if (!sigla.equals(other.sigla))
            return false;
        if (periculosidade == null) {
            if (other.periculosidade != null)
                return false;
        } else if (!periculosidade.equals(other.periculosidade))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rodovia [sigla=" + sigla + ", periculosidade=" + periculosidade + "]";
    }

    public static boolean validarPericulosidadeRodovia(String periculosidade){
        return "A".equals(periculosidade) || "M".equals(periculosidade) || "B".equals(periculosidade);
    }
}