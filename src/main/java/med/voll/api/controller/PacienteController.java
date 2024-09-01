package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.medico.DadosAtualizadoMedico;
import med.voll.api.model.medico.DadosDetalhamentoMedico;
import med.voll.api.model.medico.DadosListagemMedico;
import med.voll.api.model.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastradoPaciente paciente)
    {

        System.out.println(paciente);
        repository.save(new Paciente(paciente));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10,page=0,sort={"nome"}) Pageable paginacao)
    {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizadoPaciente dados)
    {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id)
    {
        var paciente = repository.getReferenceById(id);
       if(paciente.isAtivo()){
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
        else {
        return null;
    }
    }

}
