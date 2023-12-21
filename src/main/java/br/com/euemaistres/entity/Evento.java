package br.com.euemaistres.entity;

import br.com.euemaistres.constants.SituacaoEvento;
import br.com.euemaistres.constants.TipoEvento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "evento", schema = "app")
public class Evento {

    @Id
    @SequenceGenerator(name = "EVENTO_GEN", sequenceName = "app.sq_evento", allocationSize = 1)
    @GeneratedValue(generator = "EVENTO_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private String descricao;

    private String local;

    private String endereco;

    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;
    private Integer duracao;

    @Column(name = "situacao varchar")
    private SituacaoEvento situacao;

    @Column(name = "informacoes_adicionais")
    private String informacoesAdicionais;

    @Column(name = "valor_contrato")
    private Float valorContrato;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "evento")
    private Set<EventoPagamentoRecebido> pagamentosRecebidos;

    @OneToMany(mappedBy = "evento")
    private Set<DespesaEvento> despesas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
