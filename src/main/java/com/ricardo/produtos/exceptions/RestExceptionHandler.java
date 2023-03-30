package com.ricardo.produtos.exceptions;

import com.ricardo.produtos.error.ErrorHandle;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/*Quando ocorre uma exceção lançada pela falha do @Valid, precisamos tratar essa informação de uma forma que fique bem mais clara.
Nesse caso, a exceção que queremos tratar é a MethodArgumentNotValidException
que é a exceção lançada quando alguma validação de um argumento anotado com @Valid falha.
* */

// estamos dizendo ao spring que esta classe é um componente especializado em tratar exceções
@RestControllerAdvice
public class RestExceptionHandler {

        @ResponseStatus(HttpStatus.BAD_REQUEST) // mapea como httpStatus:400
        @ExceptionHandler(MethodArgumentNotValidException.class) // monitora quando for esta exceção e captura ela
        public List<ErrorHandle> handle(MethodArgumentNotValidException ex ) {
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            List<ErrorHandle> errorHandleList = new ArrayList<>();
            fieldErrors.forEach( error -> {
                errorHandleList.add(new ErrorHandle(error.getField(), error.getDefaultMessage()));
            });

            return errorHandleList;
        }
}
