import services.SistemaTransitoService;

public class App {
    public static void main(String[] args) throws Exception {
        SistemaTransitoService sistemaTransitoService = new SistemaTransitoService();
        sistemaTransitoService.listarAcidentesComCondutorEmbriagado();
        sistemaTransitoService.listarQuantidadeAcidentesPorNivelDePericulosidade();
        sistemaTransitoService.listarAcidentesComVeiculosDeCarga();
        sistemaTransitoService.listarRodoviaComMaisAcidentesComBicicletas();
        sistemaTransitoService.listarRodoviaComMaiorNumeroDeFatalidades();
        sistemaTransitoService.mostrarAcidentesComVeiculosNovos();
        sistemaTransitoService.mostrarRodoviasAcidentesNoCarnaval();
    }
}
