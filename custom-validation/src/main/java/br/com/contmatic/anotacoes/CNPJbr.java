package br.com.contmatic.anotacoes;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.utilidades.MensagensErro;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The Interface CNPJbr.
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CNPJbrValidador.class)
public @interface CNPJbr {
    
    /**
     * Message.
     *
     * @return the string
     */
    String message() default MensagensErro.CNPJ_INVALIDO;

    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default {};

}
