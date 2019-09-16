package br.unicesumar.base.conceito;

import java.util.UUID;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.unicesumar.base.aluno.Aluno;
import br.unicesumar.base.avaliacao.Avaliacao;
import br.unicesumar.base.avaliacao.Avaliacao.Nota;

@Entity
@Table(name = "CONCEITO")
public class Conceito {

    @Id
    private String id;
    private Boolean aprovado;
    
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "avaliacao")
    private Avaliacao avaliacao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Nota nota;
    private Float media;

    public Conceito() {
        this.id = UUID.randomUUID().toString();

        if (nota.getNota() >= media) {
            this.setAprovado(true);
        }
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public String getId() {
        return id;
    }
    public Float getMedia() {
        this.media = 6f;
        return media;
    }
}