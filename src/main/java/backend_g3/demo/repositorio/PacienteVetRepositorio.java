package backend_g3.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import backend_g3.demo.modelo.PacientevetModelo;





public interface PacientevetRepositorio extends MongoRepository <PacientevetModelo, String> {
    //para buscar por nombre mascota
    List<PacientevetModelo> findByNombremascota(String nombremascota); 

    //para buscar por tipo mascota
    List<PacientevetModelo> findByMascota(String mascota);

    //para buscar por nombre propietario
    @Query("{'propietario.nombre':?0}")
    List<PacientevetModelo> buscarPorNombre(String nombre);

    //para buscar por telefono propietario
    @Query("{'propietario.telefono':?0}")
    List<PacientevetModelo> buscarPorTelefono(String telefono);
    
}
