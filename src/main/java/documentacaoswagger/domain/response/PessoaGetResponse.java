package documentacaoswagger.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaGetResponse {
    private Integer id;
    private String nome;
    private String email;
    private String sexo;
    private LocalDate dataNascimento;
}
