package documentacaoswagger.resource;

import documentacaoswagger.domain.entity.Pessoa;
import documentacaoswagger.domain.mapper.PessoaMapper;
import documentacaoswagger.domain.request.PessoaPostRequest;
import documentacaoswagger.domain.request.PessoaPutRequest;
import documentacaoswagger.domain.response.PessoaGetResponse;
import documentacaoswagger.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api-documentacao/pessoa")
public class PessoaResource {

    private static final String URL_ID = "/{id}";

    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public PessoaGetResponse cadastrar(@Valid @RequestBody PessoaPostRequest pessoaPostRequest) {
        Pessoa pessoa = pessoaMapper.converterParaPessoa(pessoaPostRequest);
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.cadastrar(pessoa));
    }

    @PutMapping(URL_ID)
    @ResponseStatus(OK)
    public PessoaGetResponse atualizar(@PathVariable Integer id,
                                       @Valid @RequestBody PessoaPutRequest pessoaPutRequest) {
        pessoaPutRequest.setId(id);
        Pessoa pessoa = pessoaMapper.converterParaPessoa(pessoaPutRequest);
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.atualizar(pessoa));
    }

    @GetMapping(URL_ID)
    @ResponseStatus(OK)
    public PessoaGetResponse buscarPorId(@PathVariable Integer id) {
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.buscarPorId(id));
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<PessoaGetResponse> listar() {
        return pessoaMapper.converterParaListaPessoaGetResponse(pessoaService.listar());
    }

    @DeleteMapping(URL_ID)
    @ResponseStatus(NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        pessoaService.deletar(id);
    }
}
