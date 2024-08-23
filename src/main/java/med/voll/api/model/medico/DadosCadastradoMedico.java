package med.voll.api.model.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosCadastradoMedico(
        @NotNull
        @NotEmpty
        String nome,
        @NotNull
        @NotEmpty
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco)
{

}
