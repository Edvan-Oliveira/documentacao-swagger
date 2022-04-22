package documentacaoswagger.resource.exception;

import documentacaoswagger.service.exception.PessoaServiceException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ManipuladorException {

    @ExceptionHandler(PessoaServiceException.class)
    public ResponseEntity<ErroPadrao> pessoaServiceException(PessoaServiceException excecao,
                                                             HttpServletRequest requisicao) {
        ErroPadrao erro = ErroPadrao.builder()
                .url(requisicao.getRequestURI())
                .mensagens(List.of(excecao.getMessage()))
                .status(BAD_REQUEST.value())
                .dataHora(LocalDateTime.now())
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> methodArgumentNotValidException(MethodArgumentNotValidException excecao,
                                                                      HttpServletRequest requisicao) {
        ErroPadrao erro = ErroPadrao.builder()
                .url(requisicao.getRequestURI())
                .status(BAD_REQUEST.value())
                .mensagens(obterMensagensDeValidacao(excecao))
                .dataHora(LocalDateTime.now())
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(erro);
    }

    private List<String> obterMensagensDeValidacao(MethodArgumentNotValidException excecao) {
        return excecao.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }
}
