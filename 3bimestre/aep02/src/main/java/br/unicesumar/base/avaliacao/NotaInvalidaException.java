package br.unicesumar.base.avaliacao;

public class NotaInvalidaException extends RuntimeException {
    public NotaInvalidaException(String mensagem){
        super(mensagem);
    }
}