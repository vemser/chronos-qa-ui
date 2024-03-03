package chronos.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtapaDTO {
    private String nome;
    private Integer ordemExecucao;
    private Integer duracaoDiaUtil;
    private String areaResponsavel;
}
