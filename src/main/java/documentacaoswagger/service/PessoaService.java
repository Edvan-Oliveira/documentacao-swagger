package documentacaoswagger.service;

import documentacaoswagger.domain.entity.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa cadastrar(Pessoa pessoa);

    Pessoa atualizar(Pessoa pessoa);

    Pessoa buscarPorId(Integer id);

    List<Pessoa> listar();

    void deletar(Integer id);
}
