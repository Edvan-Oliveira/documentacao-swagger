package documentacaoswagger.resource;

import documentacaoswagger.domain.entity.Pessoa;
import documentacaoswagger.domain.mapper.PessoaMapper;
import documentacaoswagger.domain.request.AtualizaSenhaPessoaRequest;
import documentacaoswagger.domain.request.PessoaPostRequest;
import documentacaoswagger.domain.request.PessoaPutRequest;
import documentacaoswagger.domain.response.PessoaGetResponse;
import documentacaoswagger.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Gerenciador de Pessoa")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api-documentacao/pessoas")
public class PessoaResource {

    private static final String URL_ID = "/{id}";

    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;

    @ApiOperation("Cadastrar uma nova pessoa")
    @ApiResponses(@ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso"))
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public PessoaGetResponse cadastrar(@Valid @RequestBody PessoaPostRequest pessoaPostRequest) {
        Pessoa pessoa = pessoaMapper.converterParaPessoa(pessoaPostRequest);
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.cadastrar(pessoa));
    }

    @ApiOperation("Atualizar uma pessoa já cadastrada")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"))
    @PutMapping(value = URL_ID, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public PessoaGetResponse atualizar(@PathVariable Integer id,
                                       @Valid @RequestBody PessoaPutRequest pessoaPutRequest) {
        pessoaPutRequest.setId(id);
        Pessoa pessoa = pessoaMapper.converterParaPessoa(pessoaPutRequest);
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.atualizar(pessoa));
    }

    @ApiOperation("Buscar uma pessoa pelo seu ID")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Pessoa encontrada com sucesso"))
    @GetMapping(value = URL_ID, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public PessoaGetResponse buscarPorId(@PathVariable Integer id) {
        return pessoaMapper.converterParaPessoaGetResponse(pessoaService.buscarPorId(id));
    }

    @ApiOperation("Listar todas as pessoas cadastradas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Listagem de pessoas realizada com sucesso"))
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<PessoaGetResponse> listar() {
        return pessoaMapper.converterParaListaPessoaGetResponse(pessoaService.listar());
    }

    @ApiOperation("Deletar uma pessoa cadastrada")
    @ApiResponses(@ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso"))
    @DeleteMapping(URL_ID)
    @ResponseStatus(NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        pessoaService.deletar(id);
    }

    @ApiOperation("Atualizar senha de uma pessoa já cadastrada")
    @ApiResponses(@ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso"))
    @PatchMapping(URL_ID)
    @ResponseStatus(NO_CONTENT)
    public void atualizarSenha(@PathVariable Integer id,
                               @RequestBody @Valid AtualizaSenhaPessoaRequest atualizaSenhaPessoaRequest) {
        atualizaSenhaPessoaRequest.setId(id);
        pessoaService.atualizarSenha(pessoaMapper.converterParaPessoa(atualizaSenhaPessoaRequest));
    }
}
