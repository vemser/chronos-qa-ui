package chronos.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuloDTO {

    private String nomeDoModulo;
    private String LoginDoInstrutorResponsavel;

    private String ConteudoProgramatico;

    private String Status;

}
