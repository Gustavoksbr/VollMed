package med.voll.api.model.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
// Esta classe então vai ser uma lista da classe Medico, cujo identificador é do tipo Long
}
