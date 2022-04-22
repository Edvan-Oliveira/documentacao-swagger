package documentacaoswagger.service.impl;

import documentacaoswagger.domain.entity.Pessoa;
import documentacaoswagger.repository.PessoaRepository;
import documentacaoswagger.service.PessoaService;
import documentacaoswagger.service.exception.PessoaServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public Pessoa cadastrar(Pessoa pessoa) {
        validarEmailExistente(pessoa);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        buscarPorId(pessoa.getId());
        validarEmailExistente(pessoa);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa buscarPorId(Integer id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaServiceException("Pessoa não encontrada"));
    }

    @Override
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @Override
    public void deletar(Integer id) {
        pessoaRepository.delete(buscarPorId(id));
    }

    @Override
    public void atualizarSenha(Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPorId(pessoa.getId());
        pessoaSalva.setSenha(pessoa.getSenha());
        pessoaRepository.save(pessoaSalva);
    }

    private void validarEmailExistente(Pessoa pessoa) {
        Optional<Pessoa> busca = pessoaRepository.findByEmail(pessoa.getEmail());
        if (busca.isPresent() && !busca.get().getId().equals(pessoa.getId()))
            throw new PessoaServiceException("Email já em uso");
    }
}
