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
@Table(name = "despesa_evento", schema = "app")
public class DespesaMensal {

    @Id
    @SequenceGenerator(name = "DESP_MENSAL_GEN", sequenceName = "app.sq_despesa_mensal", allocationSize = 1)
    @GeneratedValue(generator = "DESP_MENSAL_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String descricao;
    private Float valor;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    private String observacao;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DespesaMensal that = (DespesaMensal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
