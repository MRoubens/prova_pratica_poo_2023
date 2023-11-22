package model;

import java.util.Date;
import java.util.List;

public class Acidente {

    private Rodovia rodovia;
    private List<Veiculo> veiculos;
    private Date mesAcidente;
    private long qtFeridos;
    private long qtObitos;

    public Acidente() {
    }

    public Acidente(Rodovia rodovia, List<Veiculo> veiculos, Date mesAcidente, long qtFeridos, long qtObitos) {
        this.rodovia = rodovia;
        this.veiculos = veiculos;
        this.mesAcidente = mesAcidente;
        this.qtFeridos = qtFeridos;
        this.qtObitos = qtObitos;
    }

    public Rodovia getRodovia() {
        return rodovia;
    }

    public void setRodovia(Rodovia rodovia) {
        this.rodovia = rodovia;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Date getMesAcidente() {
        return mesAcidente;
    }

    public void setMesAcidente(Date mesAcidente) {
        this.mesAcidente = mesAcidente;
    }

    public long getQtFeridos() {
        return qtFeridos;
    }

    public void setQtFeridos(long qtFeridos) {
        this.qtFeridos = qtFeridos;
    }

    public long getQtObitos() {
        return qtObitos;
    }

    public void setQtObitos(long qtObitos) {
        this.qtObitos = qtObitos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rodovia == null) ? 0 : rodovia.hashCode());
        result = prime * result + ((veiculos == null) ? 0 : veiculos.hashCode());
        result = prime * result + ((mesAcidente == null) ? 0 : mesAcidente.hashCode());
        result = prime * result + (int) (qtFeridos ^ (qtFeridos >>> 32));
        result = prime * result + (int) (qtObitos ^ (qtObitos >>> 32));
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
        Acidente other = (Acidente) obj;
        if (rodovia == null) {
            if (other.rodovia != null)
                return false;
        } else if (!rodovia.equals(other.rodovia))
            return false;
        if (veiculos == null) {
            if (other.veiculos != null)
                return false;
        } else if (!veiculos.equals(other.veiculos))
            return false;
        if (mesAcidente == null) {
            if (other.mesAcidente != null)
                return false;
        } else if (!mesAcidente.equals(other.mesAcidente))
            return false;
        if (qtFeridos != other.qtFeridos)
            return false;
        if (qtObitos != other.qtObitos)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Acidente [rodovia=" + rodovia + ", veiculos=" + veiculos + ", mesAcidente=" + mesAcidente
                + ", qtFeridos=" + qtFeridos + ", qtObitos=" + qtObitos + "]";
    }

}
