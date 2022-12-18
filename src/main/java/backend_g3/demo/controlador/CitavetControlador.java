package backend_g3.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import backend_g3.demo.modelo.CitavetModelo;
import backend_g3.demo.servicio.CitavetServicio;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/citavet")
@CrossOrigin(origins = "*" , methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class CitavetControlador {
    @Autowired
    CitavetServicio citavetServicio;

    //Get mapping asociado al servicio para ordenar alfabeticamente las citas por veterinario:
    @GetMapping()
    public List<CitavetModelo> getAllCitavet(){
       return citavetServicio.getAllCitavet();
    }
        
    //post mapping asociado al servicio guardar cita:
    @PostMapping()
    public CitavetModelo saveCitavet(@RequestBody CitavetModelo citavet){
        return citavetServicio.saveCitavet(citavet);
    }

    //Get mapping asociado al servicio buscar paciente por nombre:
    @GetMapping("/query")    //ejemplo: http://localhost:8080/citavet/query?
    public List<CitavetModelo> getCitavetByNombreveterinario(@RequestParam("nombreveterinario")String nombreveterinario){
        return citavetServicio.getCitavetByNombreveterinario(nombreveterinario);
    }


    @DeleteMapping("/{id}")
    public String deleteCitaById(@PathVariable("id") String id) {
        return citavetServicio.eliminarPorId(id);
    }
    
}
