package br.unicesumar.base.avaliacao;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Avaliacao {

    @Id
    private String id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "bimestre")
    private Integer bimestre;
    
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public Integer getBimestre() {
        return bimestre;
    }

    public void setBimestre() {
        if (1 <= bimestre || bimestre <= 4){
            this.bimestre = bimestre;
        }
        throw new BimestreInvalidoException
        ("Só é possível utilizar os valores entre 1 e 4, inclusos, para determinar o bimestre");
    }

    public Avaliacao() {
        this.id = UUID.randomUUID().toString();
    }
// -------------------------------------------------------
    @Entity
    public static class Nota {

        @Id
        private String id;
        @NotNull
        private Float nota;
        private Float maximo;
        private Float minimo;
        public Nota() {
            this.id = UUID.randomUUID().toString();
        //     if(this.nota < minimo || this.nota > maximo){
        //         throw new NotaInvalidaException("Não é possível salvar esta nota");
        // }else
        //     this.nota = nota;
        }

        public String getId() {
            return id;
        }

        public Float getNota() {
            return nota;
        }

        public void setNota(Float valor) {
            if(minimo <= this.nota || this.nota <= maximo) {
                this.nota = valor;
            }
            throw new NotaInvalidaException("Não é possível salvar esta nota");
        }

        public Float getMaximo() {
            return 10f;
        }

        public Float getMinimo() {
            return 0f;
        }
    }
}
