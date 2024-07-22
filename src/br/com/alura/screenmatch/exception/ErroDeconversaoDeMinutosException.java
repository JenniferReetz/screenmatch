package br.com.alura.screenmatch.exception;

public class ErroDeconversaoDeMinutosException extends RuntimeException {
    private String mensagem;
    public ErroDeconversaoDeMinutosException(String mensagem) {
    this.mensagem = mensagem;
    }
@Override
    public String getMessage() {
        return this.mensagem;
    }
}
