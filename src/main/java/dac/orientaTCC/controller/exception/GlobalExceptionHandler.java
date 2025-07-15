package dac.orientaTCC.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dac.orientaTCC.exception.TrabalhoAcademicoNaoEncontradoPorMatriculaException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura exceções de validação creates
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        ErrorMessage error = new ErrorMessage(
                request,
                HttpStatus.BAD_REQUEST,
                "Erro de validação nos campos.",
                ex.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // excecao personalizada
    @ExceptionHandler(TrabalhoAcademicoNaoEncontradoPorMatriculaException.class)
    public ResponseEntity<ErrorMessage> handleTrabalhoNaoEncontrado(
            TrabalhoAcademicoNaoEncontradoPorMatriculaException ex, HttpServletRequest request) {
        ErrorMessage error = new ErrorMessage(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
