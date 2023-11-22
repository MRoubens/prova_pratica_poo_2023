package services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Pessoa;
import model.Veiculo;
import utils.Utils;

public class VeiculoService {

    public List<Veiculo> cadastrarVeiculo() {
        PessoasService pessoasService = new PessoasService();
        String tipoVeiculo = "";
        Date anoFabricacao = new Date();
        List<Pessoa> pessoas = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        double qtCarga = 0.0;
        do{
            tipoVeiculo = informarTipoVeiculo();
            anoFabricacao = informarAnoFabricacao();
            
            if("CM".equals(tipoVeiculo)){
                qtCarga = informarQtCarga();
            }
            
            pessoas = pessoasService.cadastrarPessoas();
            veiculos.add(new Veiculo(anoFabricacao, pessoas, tipoVeiculo, qtCarga));
        }while(Utils.inputYesOrNoOtpion("Cadastro Veiculo ", "Deseja informa mais um veiculo? ") == 0);

        return veiculos;
    }

    private String informarTipoVeiculo(){
        String tipoVeiculo = "";
        do {
            tipoVeiculo = Utils.inputText("Tipo Veiculo", "Informe o tipo do veiculo \nCarro (C) \nCaminhão (CM)\nBicicleta (B)").toUpperCase();
        }while(!Veiculo.validarTipoVeiculo(tipoVeiculo) || !Utils.isDefined(tipoVeiculo));
        return tipoVeiculo;
    }
    
    private Double informarQtCarga(){
        Double qtCarga = 0.0;
        do {
            qtCarga = Utils.inputNumber("Quantidade Carga no Veiculo", "Informe a quantidade de carga no veiculo");
        }while(!Utils.isDefined(qtCarga) || qtCarga < 0);
        return qtCarga;
    }

    private Date informarAnoFabricacao(){
        Date date = new Date();
        try {
            do{
                date = Utils.convertStringToDate(Utils.inputText("Data de Fabricação do Veículo", "Informe o ano de fabricação do veículo (dia/mes/ano): "));
            }while(!Utils.isDefined(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
