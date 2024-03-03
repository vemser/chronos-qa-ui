package chronos.data.factory.datafaker;

import chronos.data.dto.EdicaoDTO;
import chronos.data.dto.LoginDTO;
import chronos.utils.ConfigProperties;
import chronos.utils.DataFakerGenerator;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class EdicaoData {

    private static final Faker faker = new Faker();

    public EdicaoDTO edicaoDadosValidos() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Edicao:" + faker.letterify("??????????"));
        edicaoDTO.setDataInicial(LocalDate.now());
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoSemNome() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome(StringUtils.EMPTY);
        edicaoDTO.setDataInicial(LocalDate.now());
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoComNomeComMaisDe20Caracteres() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Edicao:" + faker.letterify("???????????????????????????????????????????"));
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataInicial(LocalDate.now());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoComNomeComMenosDe4Caracteres() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome(faker.letterify("???"));
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataInicial(LocalDate.now());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoComDescricaoComMaisDe255Caracteres() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Edicao:" + faker.letterify("??????????"));
        edicaoDTO.setDescricao(faker.lorem().characters(256));
        edicaoDTO.setDataInicial(LocalDate.now());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoSemDataDeInicio() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Edicao:" + faker.letterify("??????????"));
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

}
