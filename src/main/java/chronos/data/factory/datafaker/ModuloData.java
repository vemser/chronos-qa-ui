package chronos.data.factory.datafaker;

import chronos.data.dto.LoginDTO;
import chronos.data.dto.ModuloDTO;
import chronos.utils.ConfigProperties;
import chronos.utils.DataFakerGenerator;
import net.datafaker.Faker;

public class ModuloData {
    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public ModuloDTO moduloValido() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo("Modulo " + dataFakerGenerator.number());
        moduloDTO.setLoginDoInstrutorResponsavel(ConfigProperties.properties.getProperty("UserAdmin"));
        moduloDTO.setConteudoProgramatico(dataFakerGenerator.mensagemFaker());

        return moduloDTO;
}

    public ModuloDTO moduloNomeVazio() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo("");
        moduloDTO.setLoginDoInstrutorResponsavel(ConfigProperties.properties.getProperty("UserAdmin"));
        moduloDTO.setConteudoProgramatico(dataFakerGenerator.mensagemFaker());

        return moduloDTO;

    }

    public ModuloDTO modulosCamposObrigatorios() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo("Modulo " +dataFakerGenerator.titleFaker());
        return moduloDTO;

}
  public ModuloDTO moduloTodosOsCamposVazios(){
       ModuloDTO moduloDTO = new ModuloDTO();
      moduloDTO.setNomeDoModulo("");
      moduloDTO.setLoginDoInstrutorResponsavel("");
      moduloDTO.setConteudoProgramatico("");

      return moduloDTO;

  }
    public ModuloDTO moduloComCampoNomeCom51Caractere() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo("Modulo " + dataFakerGenerator.number51());
        moduloDTO.setLoginDoInstrutorResponsavel(ConfigProperties.properties.getProperty("UserAdmin"));
        moduloDTO.setConteudoProgramatico("Conteudo " + dataFakerGenerator.mensagemFaker());

        return moduloDTO;


    }

    public ModuloDTO moduloComCampoNomeCom1Caractere() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo(dataFakerGenerator.number1());
        moduloDTO.setLoginDoInstrutorResponsavel(ConfigProperties.properties.getProperty("UserAdmin"));
        moduloDTO.setConteudoProgramatico("Conteudo " + dataFakerGenerator.mensagemFaker());

        return moduloDTO;


    }
    public ModuloDTO moduloComCampoConteudoProgramatico256Caracteres() {
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setNomeDoModulo("Modulo " + dataFakerGenerator.number());
        moduloDTO.setLoginDoInstrutorResponsavel(ConfigProperties.properties.getProperty("UserAdmin"));
        moduloDTO.setConteudoProgramatico("Conteudo " + dataFakerGenerator.number256());

        return moduloDTO;


    }

}
