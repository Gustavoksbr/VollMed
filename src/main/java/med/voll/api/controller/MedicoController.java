package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastradoMedico dados)
    {

        System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10,page=0,sort={"nome"}) Pageable paginacao)
    {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    //    @GetMapping
//    public List<DadosListagemMedico> listar()
//    {
//        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//    }
    // retorna tudo, sem filtragem de atributos:
    // @GetMapping
    //public List<Medico> listar()
    //{
//
      //  return repository.findAll();
    //}

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizadoMedico dados)
    {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
//    Exclusao tradicional - Deleta no banco de dados:
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id)
//    {
//        repository.deleteById(id);
//    }
}
