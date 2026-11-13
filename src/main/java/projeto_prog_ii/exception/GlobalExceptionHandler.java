package projeto_prog_ii.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApi(ApiException ex, HttpServletRequest req) {
        log.warn("{} em {}: {}", ex.getClass().getSimpleName(), req.getRequestURI(), ex.getMessage());
        return resposta(ex.getStatus(), ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleIntegridade(DataIntegrityViolationException ex, HttpServletRequest req) {
        log.warn("Violação de integridade em {}: {}", req.getRequestURI(), ex.getMostSpecificCause().getMessage());
        return resposta(HttpStatus.CONFLICT, "A operação viola uma regra de integridade dos dados.", req.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInesperado(Exception ex, HttpServletRequest req) {
        log.error("Erro inesperado em {}", req.getRequestURI(), ex);
        return resposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno. Tente novamente mais tarde.", req.getRequestURI());
    }

    // Validação (@Valid): devolve todos os campos inválidos
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorResponse.CampoInvalido> campos = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> new ErrorResponse.CampoInvalido(e.getField(), e.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest()
                .body(corpo(HttpStatus.BAD_REQUEST, "Dados inválidos.", caminho(request), campos));
    }

    // Demais exceções do Spring MVC (JSON malformado, id inválido, 404, 405...) no mesmo formato
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        HttpStatus status = HttpStatus.valueOf(statusCode.value());
        String mensagem = switch (status) {
            case NOT_FOUND -> "Recurso não encontrado.";
            case METHOD_NOT_ALLOWED -> "Método HTTP não permitido para este endereço.";
            case UNSUPPORTED_MEDIA_TYPE -> "Tipo de conteúdo não suportado.";
            default -> status.is4xxClientError() ? "Requisição inválida." : "Erro interno. Tente novamente mais tarde.";
        };
        return ResponseEntity.status(statusCode).headers(headers)
                .body(corpo(status, mensagem, caminho(request), null));
    }

    private ResponseEntity<ErrorResponse> resposta(HttpStatus status, String mensagem, String caminho) {
        return ResponseEntity.status(status).body(corpo(status, mensagem, caminho, null));
    }

    private ErrorResponse corpo(HttpStatus status, String mensagem, String caminho,
                                List<ErrorResponse.CampoInvalido> campos) {
        return new ErrorResponse(Instant.now(), status.value(), status.getReasonPhrase(), mensagem, caminho, campos);
    }

    private String caminho(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }
}