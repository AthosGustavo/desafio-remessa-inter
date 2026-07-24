package br.com.remessa.portalbancario.domain.ports.out;

public interface SenhaPort {
    boolean confere(String senhaPura, String senhaHash);
}
