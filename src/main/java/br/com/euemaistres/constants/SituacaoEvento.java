package br.com.euemaistres.constants;

public enum SituacaoEvento {

    FECHADO("Fechado"),
    EM_ABERTO("Em Aberto");

    private final String descricao;

    SituacaoEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
