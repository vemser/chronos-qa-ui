package chronos.data.factory.datafaker;


import chronos.data.dto.EtapaDTO;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class EtapaData {
    private static final Faker faker = new Faker();

    public EtapaDTO etapaDadosValidos() {
        EtapaDTO etapaDTO = new EtapaDTO();
        etapaDTO.setNome("Etapa:" + faker.letterify("??????????"));
        etapaDTO.setOrdemExecucao(faker.random().nextInt(5, 10));
        etapaDTO.setDuracaoDiaUtil(faker.random().nextInt(1, 10));
        return etapaDTO;
    }

    public EtapaDTO etapaComCampoNomeVazio() {
        EtapaDTO etapaDTO = new EtapaDTO();
        etapaDTO.setNome(StringUtils.EMPTY);
        etapaDTO.setOrdemExecucao(faker.random().nextInt(5, 10));
        etapaDTO.setDuracaoDiaUtil(faker.random().nextInt(1, 10));
        return etapaDTO;
    }

    public EtapaDTO etapaComCampoOrdemExecucaoVazio() {
        EtapaDTO etapaDTO = new EtapaDTO();
        etapaDTO.setNome("Etapa:" + faker.letterify("??????????"));
        etapaDTO.setDuracaoDiaUtil(faker.random().nextInt(1, 10));
        return etapaDTO;
    }

    public EtapaDTO etapaComCampoDuracaoVazio() {
        EtapaDTO etapaDTO = new EtapaDTO();
        etapaDTO.setNome("Etapa:" + faker.letterify("??????????"));
        etapaDTO.setOrdemExecucao(faker.random().nextInt(5, 10));
        return etapaDTO;
    }

    public EtapaDTO etapaComCampoNomeMaiorQue50Caracteres() {
        EtapaDTO etapaDTO = new EtapaDTO();
        etapaDTO.setNome("Etapa:" + faker.lorem().characters(51));
        etapaDTO.setOrdemExecucao(faker.random().nextInt(5, 10));
        etapaDTO.setDuracaoDiaUtil(faker.random().nextInt(1, 10));
        return etapaDTO;
    }

}
