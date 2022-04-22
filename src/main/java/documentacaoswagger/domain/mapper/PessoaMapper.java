package documentacaoswagger.domain.mapper;

import documentacaoswagger.domain.entity.Pessoa;
import documentacaoswagger.domain.request.PessoaPostRequest;
import documentacaoswagger.domain.request.PessoaPutRequest;
import documentacaoswagger.domain.response.PessoaGetResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PessoaMapper {
    public abstract Pessoa converterParaPessoa(PessoaPostRequest pessoaPostRequest);
    public abstract Pessoa converterParaPessoa(PessoaPutRequest pessoaPutRequest);
    public abstract PessoaGetResponse converterParaPessoaGetResponse(Pessoa pessoa);
    public abstract List<PessoaGetResponse> converterParaListaPessoaGetResponse(List<Pessoa> pessoas);
}
