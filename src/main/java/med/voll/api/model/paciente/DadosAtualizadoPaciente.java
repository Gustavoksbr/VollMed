package med.voll.api.model.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosAtualizadoPaciente(
        @NotNull Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
