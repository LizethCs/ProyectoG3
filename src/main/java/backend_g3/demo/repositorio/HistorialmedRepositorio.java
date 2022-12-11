package backend_g3.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend_g3.demo.modelo.HistorialmedModelo;



public interface HistorialmedRepositorio extends MongoRepository<HistorialmedModelo, String>{
    
}
