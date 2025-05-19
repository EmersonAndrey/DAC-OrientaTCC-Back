package dac.orientaTCC.enums;

public enum StatusPDF {

    PENDENTE("Pendente"),
    AVALIADO("Avaliado"),
    REJEITADO("Rejeitado");

    private final String descricao;

    StatusPDF(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
