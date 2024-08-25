package med.voll.api.model.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosCadastradoPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String telefone,
        @NotNull @Valid
        DadosEndereco endereco) {


}
