package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void gerarPaciente(@RequestBody @Valid DadosCadastradoPaciente paciente)
    {

        System.out.println(paciente);
        repository.save(new Paciente(paciente));
    }
}
