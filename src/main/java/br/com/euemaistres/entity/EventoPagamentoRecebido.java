package br.com.euemaistres.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "evento_pagamento_recebido", schema = "app")
public class EventoPagamentoRecebido {

    @Id
    @SequenceGenerator(name = "EVENT_PG_REC_GEN", sequenceName = "app.sq_evento_pagamento_recebido", allocationSize = 1)
    @GeneratedValue(generator = "EVENT_PG_REC_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private Float valor;

    private String observacao;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventoPagamentoRecebido that = (EventoPagamentoRecebido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
