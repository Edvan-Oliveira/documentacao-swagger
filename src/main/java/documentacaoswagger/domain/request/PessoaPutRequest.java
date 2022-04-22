package documentacaoswagger.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaPutRequest {
    private Integer id;
    private String nome;
    private String email;
    private String sexo;
    private LocalDate dataNascimento;
    private String senha;
}
