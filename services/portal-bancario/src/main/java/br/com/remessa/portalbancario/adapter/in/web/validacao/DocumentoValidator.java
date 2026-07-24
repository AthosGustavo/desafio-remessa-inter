package br.com.remessa.portalbancario.adapter.in.web.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<DocumentoValido, String> {

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {
        if (documento == null || documento.isBlank()) {
            return false;
        }

        return DocumentoUtils.isDocumentoValido(documento);
    }

    public boolean documentoValido(String documento) {
        if (documento == null || documento.isBlank()) {
            return false;
        }
        return DocumentoUtils.isDocumentoValido(documento);
    }
}
