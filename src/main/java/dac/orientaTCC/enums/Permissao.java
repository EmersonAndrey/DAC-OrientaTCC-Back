package dac.orientaTCC.enums;

public enum Permissao {
    
    ADMIN("Admin"),
    ORIENTADOR("Orientador");

    private final String descricao;

    Permissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
