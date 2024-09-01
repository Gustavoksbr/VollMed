package med.voll.api.model.medico;

import med.voll.api.model.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico (Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
//o funcionamento do record proporciona associar os valores pela ordem. Entao, os atributos dos dois construtores devem seguir a mesma ordem
    }
}

