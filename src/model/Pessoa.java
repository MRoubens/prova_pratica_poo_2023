package model;

public class Pessoa {

    private String nome;
    private int idade;
    private String sexo;
    private boolean condutor;
    private boolean embriagado;

    public Pessoa() {
    }
    
    public Pessoa(String nome, int idade, String sexo, boolean condutor, boolean embriagado) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.condutor = condutor;
        this.embriagado = embriagado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isCondutor() {
        return condutor;
    }

    public void setCondutor(boolean condutor) {
        this.condutor = condutor;
    }

    public boolean isEmbriagado() {
        return embriagado;
    }

    public void setEmbriagado(boolean embriagado) {
        this.embriagado = embriagado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + idade;
        result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
        result = prime * result + (condutor ? 1231 : 1237);
        result = prime * result + (embriagado ? 1231 : 1237);
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
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idade != other.idade)
            return false;
        if (sexo == null) {
            if (other.sexo != null)
                return false;
        } else if (!sexo.equals(other.sexo))
            return false;
        if (condutor != other.condutor)
            return false;
        if (embriagado != other.embriagado)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", condutor=" + condutor
                + ", embriagado=" + embriagado + "]";
    }
    
    public static boolean validarSexoPessoa(String sexo){
        return "M".equals(sexo) || "F".equals(sexo);
    }
}