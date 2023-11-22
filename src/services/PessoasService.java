package services;

import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import utils.Utils;

public class PessoasService {
    
    public List<Pessoa> cadastrarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        do{
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(informarNome());
            pessoa.setSexo(informarSexo());
            pessoa.setIdade(informarIdade());
            pessoa.setCondutor(informarCondutor());
            pessoa.setEmbriagado(informarSeCondutorEstavaEmbreagaado());
            pessoas.add(pessoa);
        }while(Utils.inputYesOrNoOtpion("Cadastro Pessoa ", "Deseja informa mais uma pessoa? ") == 0);

        return pessoas;
    }

    private String informarNome(){
        String nomePessoa = "";
        do{
            nomePessoa = Utils.inputText("Nome Pessoa", "Informe o nome da pessoa: ");
        }while(!Utils.isDefined(nomePessoa));
        return nomePessoa;
    }

    private int informarIdade(){
        int idadePessoa = 0;
        do{
            idadePessoa = Integer.parseInt(Utils.inputText("Idade Pessoa", "Informe a idade da pessoa: "));
        }while(!Utils.isDefined(idadePessoa) || idadePessoa <= 0);
        return idadePessoa;
    }

    private String informarSexo(){
        String sexoPessoa = "";
        do{
            sexoPessoa = Utils.inputText("Sexo Pessoa", "Informe o sexo da pessoa \nMasculino (M) \nFeminino (F): ").toUpperCase();
        }while(!Utils.isDefined(sexoPessoa) || !Pessoa.validarSexoPessoa(sexoPessoa));
        return sexoPessoa;
    }

    private boolean informarCondutor(){
        return Utils.inputYesOrNoOtpion("Confirma Condutor", "Informe se a pessoa é o condutor") == 0;
    }

    private boolean informarSeCondutorEstavaEmbreagaado(){
        return Utils.inputYesOrNoOtpion("Confirma Embriaguez", "Informe se o condutor estava embriagado") == 0;
    }
}
