package med.voll.api.controller;

import med.voll.api.model.paciente.DadosPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @PostMapping
    public void gerarPaciente(@RequestBody DadosPaciente paciente)
    {
        System.out.println(paciente);
    }
}
