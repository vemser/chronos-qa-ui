package chronos.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstagiarioDTO {
    private String nome;
    private String curso;
    private String CPF;
    private String instituicao;
    private String github;
    private LocalDate dataNascimento;
    private String linkedin;
    private String telefone;
    private String status;
    private String emailPessoal;
    private String observacao;
    private String emailCorporativo;
    private String edicao;
    private String cidade;
    private String estado;
    private String trilha;
}
