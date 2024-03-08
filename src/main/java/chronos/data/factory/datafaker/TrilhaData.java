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

    public static TrilhaCadastroDTO trilhaValidaFrontEnd() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha("Front-end")
                .descricao("Crie experiências digitais envolventes e visualmente atraentes. Através da trilha de front-end, você será responsável por transformar designs criativos.")
                .caminhoImagem("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\VemSer_Front.png")
                .build();
    }
    public static TrilhaCadastroDTO trilhaValidaQA() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha("QA")
                .descricao("Especialize-se em Qualidade de Software. Na trilha de QA, você aprenderá e atuará com a garantia da qualidade de nossos produtos, trabalhando com testes detalhados.")
                .caminhoImagem("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\Vem_Ser_QA.png")
                .build();
    }
    public static TrilhaCadastroDTO trilhaValidaBackEnd() {
        return TrilhaCadastroDTO.builder()
                .nomeTrilha("Back-end")
                .descricao("Torne-se um especialista em garantir que sistemas funcionem de forma eficiente, escalável e segura. Através da trilha de back-end, você irá atuar com lógica de servidor, gestão de bancos de dados, integração de serviços.")
                .caminhoImagem("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\images\\VemSer_Back.png")
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

    public static TrilhaCadastroDTO trilhaValidaEdicao(){
        return TrilhaCadastroDTO.builder()
                .nomeTrilha("trilha " + DataFakerGenerator.number())
                .descricao(DataFakerGenerator.description())
                .build();
    }

}
