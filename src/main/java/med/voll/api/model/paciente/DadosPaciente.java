package med.voll.api.model.paciente;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String email,

        String telefone,
        @NotBlank
        DadosEndereco endereco
) {
}