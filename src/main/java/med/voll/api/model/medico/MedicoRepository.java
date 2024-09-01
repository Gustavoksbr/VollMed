package med.voll.api.model.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Esta classe então vai ser uma lista da classe Medico, cujo identificador é do tipo Long
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    //findallByAtivo true eh um metodo interessante pq o Spring reconhece que a primeira palavra depois de "findAll" é o atributo da tabela, e a segunda palavra é o valor
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

}
