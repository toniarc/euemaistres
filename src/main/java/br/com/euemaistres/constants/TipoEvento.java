package br.com.euemaistres.constants;

public enum TipoEvento {
    ANIVERSARIO("Aniversário"),
    CASAMENTO("Casamento"),
    CONTRATERNIZACAO("Confraternização"),
    FORMATURA("Formatura");


    private final String descricao;

    TipoEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
