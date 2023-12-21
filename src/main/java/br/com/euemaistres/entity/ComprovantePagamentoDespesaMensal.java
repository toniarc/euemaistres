package br.com.euemaistres.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "despesa_evento", schema = "app")
public class ComprovantePagamentoDespesaMensal {

    @Id
    @SequenceGenerator(name = "COMP_PAG_DESP_MENSAL_GEN", sequenceName = "app.sq_comprovante_pagamento_despesa_mensal", allocationSize = 1)
    @GeneratedValue(generator = "COMP_PAG_DESP_MENSAL_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "despesa_mensal_id")
    private DespesaMensal despesaMensal;

    @Column(name = "mime_type")
    private String mime_type;

    private String arquivo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprovantePagamentoDespesaMensal that = (ComprovantePagamentoDespesaMensal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
