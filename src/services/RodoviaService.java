package services;

import model.Rodovia;
import utils.Utils;

public class RodoviaService {

    public Rodovia cadastrarRodovia(){

        String siglaRodovia = informarSiglaRodovia();
        String periculosidade = informarPericulosidadeRodovia();

        return new Rodovia(siglaRodovia, periculosidade);
    }
    
    private String informarSiglaRodovia(){
        String siglaRodovia = "";
        do{
            siglaRodovia = Utils.inputText("Sigla Rodovia", "Informe a sigla da rodovia: ").toUpperCase();
        }while(!Utils.isDefined(siglaRodovia));
        return siglaRodovia;
    }

    private String informarPericulosidadeRodovia(){
        String periculosidadeRodovia = "";
        do{
            periculosidadeRodovia = Utils.inputText("Periculosidade Rodovia", "Informe a periculosidade da rodovia \nBaixa (B), \nMédia (M) \nAlta (A): ");
        }while(!Utils.isDefined(periculosidadeRodovia) || !Rodovia.validarPericulosidadeRodovia(periculosidadeRodovia));
        return periculosidadeRodovia;
    }
}