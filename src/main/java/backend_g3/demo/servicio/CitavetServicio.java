package backend_g3.demo.servicio;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend_g3.demo.modelo.CitavetModelo;
import backend_g3.demo.repositorio.CitavetRepositorio;
import backend_g3.demo.repositorio.VeterinarioRepositorio;


@Service
public class CitavetServicio {
    @Autowired
    CitavetRepositorio citavetRepositorio;
    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    //servicio para listar las citas veterinarias:
   public List<CitavetModelo> getAllCitavet(){
    List<CitavetModelo> citavet=citavetRepositorio.findAll();
    citavet.sort((Comparator.comparing(CitavetModelo::getNombreveterinario))); //ordenar por nombre veterinario
    return citavet;
   }

    //servicio para guardar cita:
    public CitavetModelo saveCitavet(CitavetModelo citavet){
        return citavetRepositorio.save(citavet);
    }
    
    //servicio para buscar cita veterinaria por nombre veterinario:
    public List<CitavetModelo> getCitavetByNombreveterinario(String nombreveterinario){
        return citavetRepositorio.findByNombreveterinario(nombreveterinario);
    }

    public String eliminarPorId(String id) {
        if (citavetRepositorio.existsById(id)) {
            citavetRepositorio.deleteById(id);
            return "Cita eliminada.";
        } else {
            return "No eliminada.";
        }
    }
}
