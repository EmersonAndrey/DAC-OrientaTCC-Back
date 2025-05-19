package dac.orientaTCC.enums;

public enum TipoUsuario {

    ALUNO("Aluno"),
    ORIENTADOR("Orientador");

    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
