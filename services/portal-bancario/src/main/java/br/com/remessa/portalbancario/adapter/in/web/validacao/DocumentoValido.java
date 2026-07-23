package br.com.remessa.portalbancario.adapter.in.web.validacao;

import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DocumentoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentoValido {

    String message() default "Documento inválido. Informe um CPF ou CNPJ válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}