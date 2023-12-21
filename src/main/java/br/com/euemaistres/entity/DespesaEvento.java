package br.com.euemaistres.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "despesa_evento", schema = "app")
public class DespesaEvento {

    @Id
    @SequenceGenerator(name = "DESP_EVENTO_GEN", sequenceName = "app.sq_despesa_evento", allocationSize = 1)
    @GeneratedValue(generator = "DESP_EVENTO_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private String descricao;
    private Float valor;
    private String observacao;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "despesaEvento")
    private Set<ComprovantePagamentoDespesaEvento> pagamentos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DespesaEvento that = (DespesaEvento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
