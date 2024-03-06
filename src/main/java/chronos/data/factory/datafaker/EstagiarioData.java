package chronos.data.factory.datafaker;


import chronos.data.dto.EstagiarioDTO;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Locale;

public class EstagiarioData {

    public static final Faker FAKER = new Faker(new Locale("pt-BR"));

    public EstagiarioDTO estagiarioDadosValidos() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome(FAKER.name().firstName() + " "  + FAKER.name().lastName() + " "  + FAKER.name().nameWithMiddle());
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setCurso("Belo Horizonte");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }
    public EstagiarioDTO estagiarioSemCampoNome() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome(StringUtils.EMPTY);
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setCurso("Belo Horizonte");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoCurso() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setCurso(StringUtils.EMPTY);
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoCPF() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(StringUtils.EMPTY);
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoInstituicao() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao(StringUtils.EMPTY);
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoDataDeNascimento() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoTelefone() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone(StringUtils.EMPTY);
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoStatus() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoEmailPessoal() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailPessoal(StringUtils.EMPTY);
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoEmailCorporativo() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(StringUtils.EMPTY);
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoCidade() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado("RS");
        estagiarioDTO.setCidade(StringUtils.EMPTY);
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }

    public EstagiarioDTO estagiarioSemCampoEstado() {
        EstagiarioDTO estagiarioDTO = new EstagiarioDTO();
        estagiarioDTO.setNome("Estagiario:" + FAKER.letterify("??????????"));
        estagiarioDTO.setCPF(FAKER.cpf().valid(false));
        estagiarioDTO.setDataNascimento(LocalDate.of(1990, 01, 26));
        estagiarioDTO.setEmailPessoal(FAKER.internet().emailAddress());
        estagiarioDTO.setEmailCorporativo(FAKER.internet().emailAddress());
        estagiarioDTO.setTelefone("21936184249");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setEstado(StringUtils.EMPTY);
        estagiarioDTO.setCidade("Porto Alegre");
        estagiarioDTO.setCurso("Análise e Desenvolvimento de Sistemas");
        estagiarioDTO.setInstituicao("Pontifícia Universidade Example");
        estagiarioDTO.setGithub("https://github.c/example");
        estagiarioDTO.setLinkedin("https://linkedin.c/example");
        estagiarioDTO.setStatus("ALO");
        estagiarioDTO.setObservacao("Desligado devido ao comportamento");
        return estagiarioDTO;
    }
}
