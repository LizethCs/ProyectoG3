package backend_g3.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;

import backend_g3.demo.modelo.CitavetModelo;




public interface CitavetRepositorio extends MongoRepository<CitavetModelo, String> {
    //para buscar por nombre veterinario:
    List<CitavetModelo> findByNombreveterinario(String nombreveterinario);
    
}
