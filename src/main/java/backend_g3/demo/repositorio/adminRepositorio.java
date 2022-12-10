package backend_g3.demo.repositorio;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import backend_g3.demo.modelo.adminModelo;

@Repository
public interface adminRepositorio extends MongoRepository<adminModelo, String> {
    List<adminModelo> findByLastname(String lastname); //keywords for query methods
}