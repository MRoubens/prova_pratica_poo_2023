package services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Acidente;
import utils.Utils;

public class AcidenteService {
    
    public List<Acidente> cadastrarAcidente(){
        List<Acidente> acidentes = new ArrayList<>();
        VeiculoService veiculoService = new VeiculoService();
        RodoviaService rodoviaService = new RodoviaService();

        do{
            Acidente acidente = new Acidente();

            acidente.setRodovia(rodoviaService.cadastrarRodovia());
            acidente.setVeiculos(veiculoService.cadastrarVeiculo());
            acidente.setMesAcidente(informarDataAcidente());
            acidente.setQtFeridos(informarQtFeridos());
            acidente.setQtObitos(informarQtObitos());

            acidentes.add(acidente);
        }while(Utils.inputYesOrNoOtpion("Cadastro Acidente ", "Deseja informa mais um aciedente? ") == 0);
        
        return acidentes;
    }

    private Long informarQtFeridos(){
        long qtFeridos = 0;
        do{
            qtFeridos = Long.parseLong(Utils.inputText("Quantidade Feridos", "Informe a quantidade de feridos: "));
        }while(!Utils.isDefined(qtFeridos) || qtFeridos < 0);
        return qtFeridos;
    }

    private Long informarQtObitos(){
        long qtObitos = 0;
        do{
            qtObitos = Long.parseLong(Utils.inputText("Quantidade Óbitos", "Informe a quantidade de óbitos: "));
        }while(!Utils.isDefined(qtObitos) || qtObitos < 0);
        return qtObitos;
    }

    private Date informarDataAcidente(){
        Date date = new Date();
        try {
            do{
                date = Utils.convertStringToDate(Utils.inputText("Data do acidente", "Informe a data do acidente (dia/mes/ano): "));
            }while(!Utils.isDefined(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}