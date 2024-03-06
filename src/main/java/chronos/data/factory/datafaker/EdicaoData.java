package chronos.data.factory.datafaker;

import chronos.data.dto.EdicaoDTO;
import chronos.utils.DataFakerGenerator;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Locale;

public class EdicaoData {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public EdicaoDTO edicaoDadosValidos() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome(DataFakerGenerator.evento());
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoDadosValidosEndToEnd() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Vem Ser" + " " + faker.numerify("##"));
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
        edicaoDTO.setDescricao("Vem Ser DBC é um programa de aceleração de conhecimento técnico. Trata-se de uma jornada exigente, com mais de 2.700 pessoas inscritas na última edição e 40 inscritos em média por vaga, com profissionais de várias localidades do Brasil.");
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoSemNome() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome(StringUtils.EMPTY);
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
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
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoComNomeComMenosDe4Caracteres() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome(faker.letterify("???"));
        edicaoDTO.setDescricao(faker.lorem().sentence());
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
        edicaoDTO.setDataFinal(LocalDate.now().plusMonths(2));
        edicaoDTO.setStatus("ATIVO");
        edicaoDTO.setCaminhoFoto("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\testejpg.jpg");
        return edicaoDTO;
    }

    public EdicaoDTO edicaoComDescricaoComMaisDe255Caracteres() {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setNome("Edicao:" + faker.letterify("??????????"));
        edicaoDTO.setDescricao(faker.lorem().characters(256));
        edicaoDTO.setDataInicial(LocalDate.now().plusDays(1));
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
