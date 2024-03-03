package chronos.data.factory.datafaker;

import chronos.data.dto.TrilhaCadastroDTO;
import chronos.utils.DataFakerGenerator;
import org.apache.commons.lang3.StringUtils;

public class TrilhaData {

    public static TrilhaCadastroDTO trilhaValida() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha(DataFakerGenerator.evento())
                .descricao(DataFakerGenerator.description())
                .build();
    }
    public static TrilhaCadastroDTO trilhaComNomeVazio() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha(StringUtils.EMPTY)
                .descricao(DataFakerGenerator.description())
                .build();
    }

    public static TrilhaCadastroDTO trilhaComNomeMaior50Caracteres() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha(DataFakerGenerator.nome50())
                .descricao(DataFakerGenerator.description())
                .build();
    }

    public static TrilhaCadastroDTO trilhaComDescricao256Caracteres() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha(DataFakerGenerator.evento())
                .descricao(DataFakerGenerator.descricao256())
                .build();
    }

}
