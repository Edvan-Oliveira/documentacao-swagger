package documentacaoswagger.resource.exception;

import documentacaoswagger.service.exception.PessoaServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ManipuladorException {

    @ExceptionHandler(PessoaServiceException.class)
    public ResponseEntity<ErroPadrao> pessoaServiceException(PessoaServiceException excecao,
                                                             HttpServletRequest requisicao) {
        ErroPadrao erro = ErroPadrao.builder()
                .url(requisicao.getRequestURI())
                .mensagem(excecao.getMessage())
                .status(BAD_REQUEST.value())
                .dataHora(LocalDateTime.now())
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(erro);
    }
}
