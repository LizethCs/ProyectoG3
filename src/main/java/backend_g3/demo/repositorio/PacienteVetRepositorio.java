package backend_g3.demo.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import backend_g3.demo.modelo.PacientevetModelo;


public interface PacienteVetRepositorio extends MongoRepository<PacientevetModelo, String> {
    List<PacientevetModelo> findByNickname(String nickname); //keywords for query methods
}