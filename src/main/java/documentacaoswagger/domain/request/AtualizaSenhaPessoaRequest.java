package documentacaoswagger.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AtualizaSenhaPessoaRequest {

    @NotNull(message = "O 'id' é obrigatório")
    private Integer id;

    @NotNull(message = "A 'senha' é obrigatório")
    @Size(min = 3, max = 15, message = "O intervalo de caracteres da 'senha' é de {min} até {max}")
    private String senha;
}
