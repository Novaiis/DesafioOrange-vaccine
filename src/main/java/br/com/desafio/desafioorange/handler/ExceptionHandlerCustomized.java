package br.com.desafio.desafioorange.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.desafio.desafioorange.response.ErroValidacao;
import br.com.desafio.desafioorange.response.ExceptionResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerCustomized {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErroValidacao handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest webRequest) {
        String message = ex.getMessage();
        String campo = webRequest.getDescription(false);
        if (ex.getMessage().contains("email_uk")) {
            message = "Esse email ja esta cadastrado";
            campo = "email";
        }
        if (ex.getMessage().contains("cpf_uk")) {
            message = "Esse cpf ja esta cadastrado";
            campo = "cpf";
        }
        return new ErroValidacao(campo,message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ErroValidacao> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErroValidacao> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroValidacao erro = new ErroValidacao(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleAll(Exception ex, WebRequest webRequest){
        return new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                webRequest.getDescription(false));
    }
}
