package med.voll.api.model.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;

@Table(name="pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Paciente {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private boolean ativo;
    public Paciente(DadosCadastradoPaciente dados)
    {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }
    public void atualizarInformacoes(DadosAtualizadoPaciente dados)
    {
        if (dados.nome() != null)
        {
            this.nome = dados.nome();
        }
        if(dados.email() !=null)
        {
            this.email = dados.email();
        }
        if (dados.telefone() !=null)
        {
            this.telefone = dados.nome();
        }
        if (dados.endereco() != null)
        {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
    public void excluir()
    {
        this.ativo = false;
    }

}
