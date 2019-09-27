package br.unicesumar.base.aluno;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Aluno {

    @Id
    private String id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    public Aluno() {
    this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}