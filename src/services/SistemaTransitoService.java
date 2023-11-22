package services;

import java.util.HashMap;
import java.util.List;

import model.Acidente;
import model.Pessoa;
import model.Veiculo;
import utils.Utils;

public class SistemaTransitoService {
    
    private List<Acidente> acidentes;

    public SistemaTransitoService(){
        AcidenteService acidenteService = new AcidenteService();  
        acidentes = acidenteService.cadastrarAcidente();
    }

    public void listarAcidentesComCondutorEmbriagado(){
        String listaDeAcidentesComCondutoresEmbriagados = "";
        for(Acidente acidente : acidentes){
            for(Veiculo veiculo : acidente.getVeiculos()){
                for(Pessoa pessoa : veiculo.getPessoas()){
                    if(pessoa.isEmbriagado() && pessoa.isCondutor()){
                        listaDeAcidentesComCondutoresEmbriagados += "\nRodovia acidente: \n" + acidente.getRodovia().getSigla() 
                                                                   + "\nData acidente: \n" + Utils.dateFormat(acidente.getMesAcidente()) 
                                                                    + "\nVeiculo acidente: \n" + retornaTipoVeiculo(veiculo.getTipoVeiculo()) 
                                                                    + "\nMotorista: \n" + pessoa.getNome();
                                                                     
                    }
                }
            }
        }

        Utils.showText("Lista de acidentes com condutores embriagados", listaDeAcidentesComCondutoresEmbriagados);
    }

    public void listarQuantidadeAcidentesPorNivelDePericulosidade(){
        long countAcidentesEmRodoviaPericulosidadeBaixa = 0;
        long countAcidentesEmRodoviaPericulosidadeMedia = 0;
        long countAcidentesEmRodoviaPericulosidadeAlta = 0;
        for(Acidente acidente : acidentes){
            if("B".equals(acidente.getRodovia().getPericulosidade())){
                countAcidentesEmRodoviaPericulosidadeBaixa = countAcidentesEmRodoviaPericulosidadeBaixa + 1;
            }else if("M".equals(acidente.getRodovia().getPericulosidade())){
                countAcidentesEmRodoviaPericulosidadeMedia = countAcidentesEmRodoviaPericulosidadeMedia + 1;
            }else{
                countAcidentesEmRodoviaPericulosidadeAlta = countAcidentesEmRodoviaPericulosidadeAlta + 1; 
            }
        }

        String quantidadeAcidentesPorPericulosidadeNaRodovia = "Quantidade de Acidentes em Rodovias de Baixa Periculosidade: \n" 
            + countAcidentesEmRodoviaPericulosidadeBaixa
            + "\nQuantidade de Acidentes em Rodovias de Média Periculosidade: \n" 
            + countAcidentesEmRodoviaPericulosidadeMedia
            + "\nQuantidade de Acidentes em Rodovias de Alta Periculosidade: \n" 
            + countAcidentesEmRodoviaPericulosidadeAlta;

        Utils.showText("Lista de acidentes por periculosidade da rodovia", quantidadeAcidentesPorPericulosidadeNaRodovia);
    }

    public void listarAcidentesComVeiculosDeCarga(){
        String listaDeAcidentesComVeiculosDeCarga = "";
        for(Acidente acidente : acidentes){
            for(Veiculo veiculo : acidente.getVeiculos()){
                for(Pessoa pessoa : veiculo.getPessoas()){
                    if("CM".equals(veiculo.getTipoVeiculo()) && pessoa.isCondutor()){
                        listaDeAcidentesComVeiculosDeCarga += "\nRodovia acidente: \n" + acidente.getRodovia().getSigla() 
                                                                   + "\nData acidente: \n" + Utils.dateFormat(acidente.getMesAcidente()) 
                                                                    + "\nVeiculo acidente: \n" + retornaTipoVeiculo(veiculo.getTipoVeiculo()) 
                                                                    + "\nMotorista: \n" + pessoa.getNome()
                                                                    + "\nQuantidade carga no veículo: \n" + veiculo.getQtCarga();
                                                                     
                    }
                }
            }
        }

        Utils.showText("Lista de acidentes com veículos de carga", listaDeAcidentesComVeiculosDeCarga);
    }

    public void listarRodoviaComMaisAcidentesComBicicletas(){
        String rodoviaComMaiorNumeroDeAcidentesDeBicicleta = "";
        long count = 0;
        HashMap<String, Long> listaAcidentesDeBicicletaPorRodovia = new HashMap<>();
        for(Acidente acidente : acidentes){
            for(Veiculo veiculo : acidente.getVeiculos()){
                if("B".equals(veiculo.getTipoVeiculo())){
                    if(listaAcidentesDeBicicletaPorRodovia.containsKey(acidente.getRodovia().getSigla())){
                        count = listaAcidentesDeBicicletaPorRodovia.get(acidente.getRodovia().getSigla()) + 1;
                        listaAcidentesDeBicicletaPorRodovia.replace(acidente.getRodovia().getSigla(), listaAcidentesDeBicicletaPorRodovia.get(acidente.getRodovia().getSigla()), count);
                    }else{
                        count = count + 1;
                        listaAcidentesDeBicicletaPorRodovia.put(acidente.getRodovia().getSigla(), count);
                    }
                    count = 0;
                }
            }
        }

        rodoviaComMaiorNumeroDeAcidentesDeBicicleta = retornaRodoviaComMaisAcidentesDeBicicleta(listaAcidentesDeBicicletaPorRodovia);

        Utils.showText("Rodovia com mais acidentes de bicicleta", rodoviaComMaiorNumeroDeAcidentesDeBicicleta);
    }

    private String retornaRodoviaComMaisAcidentesDeBicicleta(HashMap<String, Long> listaRodoviasAcidentes){
        long maiorNumeroDeAcidentesDeBicicleta = 0;
        String rodoviaComMaiorNumeroDeAcidentesDeBicicleta = "";
        for(Acidente acidente : acidentes){
            for(int z = 0; z < listaRodoviasAcidentes.size(); z++){
                long numeroDeAcidentesDeBicicletaNaAcidenteRodovia = listaRodoviasAcidentes.get(acidente.getRodovia().getSigla());
                if(maiorNumeroDeAcidentesDeBicicleta < numeroDeAcidentesDeBicicletaNaAcidenteRodovia){
                    maiorNumeroDeAcidentesDeBicicleta = numeroDeAcidentesDeBicicletaNaAcidenteRodovia;
                    rodoviaComMaiorNumeroDeAcidentesDeBicicleta = acidente.getRodovia().getSigla();
                }
            }
        }
        
        return rodoviaComMaiorNumeroDeAcidentesDeBicicleta + " - " + maiorNumeroDeAcidentesDeBicicleta;
    }

    public void listarRodoviaComMaiorNumeroDeFatalidades(){
        String rodoviaComMaiorNumeroDeFatalidades = "";
        HashMap<String, Long> listaAcidentesPorRodovia = new HashMap<>();
        long count = 0;
        for(Acidente acidente : acidentes){
            if(listaAcidentesPorRodovia.containsKey(acidente.getRodovia().getSigla())){
                count = listaAcidentesPorRodovia.get(acidente.getRodovia().getSigla()) + acidente.getQtObitos();
                listaAcidentesPorRodovia.replace(acidente.getRodovia().getSigla(), listaAcidentesPorRodovia.get(acidente.getRodovia().getSigla()), count);
            }else{
                count = count + acidente.getQtObitos();
                listaAcidentesPorRodovia.put(acidente.getRodovia().getSigla(), count);
            }
            count = 0;
        }

        rodoviaComMaiorNumeroDeFatalidades = retornaRodoviaComMaisAcidentesFatais(listaAcidentesPorRodovia);

        Utils.showText("Rodovia com maior número de fatalidades", rodoviaComMaiorNumeroDeFatalidades);
    }


    private String retornaRodoviaComMaisAcidentesFatais(HashMap<String, Long> listaAcidentesPorRodovia){
        long maiorNumeroDeAcidentesFatais = 0;
        String rodoviaComMaiorNumeroDeAcidentesFatais = "";
        for(Acidente acidente : acidentes){
            for(int z = 0; z < listaAcidentesPorRodovia.size(); z++){
                long numeroDeAcidentesFataisNaRodovia = listaAcidentesPorRodovia.get(acidente.getRodovia().getSigla());
                if(maiorNumeroDeAcidentesFatais < numeroDeAcidentesFataisNaRodovia){
                    maiorNumeroDeAcidentesFatais = numeroDeAcidentesFataisNaRodovia;
                    rodoviaComMaiorNumeroDeAcidentesFatais = acidente.getRodovia().getSigla();
                }
            }
        }
        
        return rodoviaComMaiorNumeroDeAcidentesFatais + " - " + maiorNumeroDeAcidentesFatais;
    }

    public void mostrarAcidentesComVeiculosNovos(){
        long count = 0;
        for(Acidente acidente : acidentes){
            for(Veiculo veiculo : acidente.getVeiculos()){
                if(Utils.getYearFromDate(veiculo.getAnoFabricacao()) >= 2013){
                    count = count + 1;
                    break;
                }
            }
        }

        Utils.showText("Total de acidentes com veículos novos", String.valueOf(count));
    }

    public void mostrarRodoviasAcidentesNoCarnaval(){
        long count = 0;
        String listaRodoviasComAcidenteNoCarnaval = "";
        for(Acidente acidente : acidentes){
            if(Utils.getMonthFromDate(acidente.getMesAcidente()) == 1 && !listaRodoviasComAcidenteNoCarnaval.contains(acidente.getRodovia().getSigla())){
                listaRodoviasComAcidenteNoCarnaval = "\n" + acidente.getRodovia().getSigla();
            }
        }

        Utils.showText("Rodovias com acidente no carnaval", String.valueOf(count));
    }
    
    private String retornaTipoVeiculo(String siglaVeiculo){
        String tipoVeiculo = "";
        switch (siglaVeiculo) {
            case "C":
                tipoVeiculo = "Carro";
                break;
            case "CM":
                tipoVeiculo = "Caminhão";
                break;
            default:
                tipoVeiculo = "Bicicleta";
        }

        return tipoVeiculo;
    }

}
