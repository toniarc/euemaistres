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
@Table(name = "comprovante_pagamento_despesa_evento", schema = "app")
public class ComprovantePagamentoDespesaEvento {

    @Id
    @SequenceGenerator(name = "COMP_PAG_DESP_EVENTO_GEN", sequenceName = "app.sq_comprovante_pagamento_despesa_evento", allocationSize = 1)
    @GeneratedValue(generator = "COMP_PAG_DESP_EVENTO_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "despesa_evento_id")
    private DespesaEvento despesaEvento;

    @Column(name = "mime_type")
    private String mimeType;

    private String arquivo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprovantePagamentoDespesaEvento that = (ComprovantePagamentoDespesaEvento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
