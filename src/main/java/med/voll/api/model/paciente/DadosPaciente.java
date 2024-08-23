package med.voll.api.model.paciente;

import med.voll.api.model.endereco.DadosEndereco;

public record DadosPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco
) {
}