package dac.orientaTCC.enums;

public enum FasesEntrega {

    ELEMENTOS_PRE_TEXTUAIS("Elementos Pré Textuais"),
    INTRODUCAO("Introducao"),
    REFERENCIAL_TEORICO("Referencial Teórico"),
    METODOLOGIA("Metodologia"),
    DESENVOLVIMENTO("Desenvolvimento"),
    CONCLUSAO("Conclusão"),
    ELEMENTOS_POS_TEXTUAIS("Elementos Pós Textuais");

    private final String descricao;

    FasesEntrega(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
