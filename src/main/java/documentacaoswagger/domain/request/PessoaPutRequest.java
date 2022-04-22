package documentacaoswagger.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaPutRequest {

    @NotNull(message = "O 'id' é obrigatório")
    private Integer id;

    @NotNull(message = "O 'nome' é obrigatório")
    @Size(min = 3, max = 50, message = "O intervalo de caracteres do 'nome' é de {min} até {max}")
    private String nome;

    @NotNull(message = "O 'email' é obrigatório")
    @Email(message = "Esse é um email inválido")
    @Size(min = 10, max = 50, message = "O intervalo de caracteres do 'email' é de {min} até {max}")
    private String email;

    @NotNull(message = "O 'sexo' é obrigatório")
    @Size(min = 1, max = 1, message = "O 'sexo' é {min} caractere")
    private String sexo;

    @NotNull(message = "A 'dataNascimento' é obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "A 'senha' é obrigatória")
    @Size(min = 3, max = 15, message = "O intervalo de caracteres da 'senha' é de {min} até {max}")
    private String senha;
}
