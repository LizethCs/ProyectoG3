package backend_g3.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import backend_g3.demo.servicio.PacienteVetServicio;

import backend_g3.demo.modelo.PacientevetModelo;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/PacienteVet")
@CrossOrigin(origins = "*")

public class PacienteVetControlador {
    @Autowired
    PacienteVetServicio PacienteVetServicio;

    
    @GetMapping()
    public List<PacientevetModelo> getAllPacienteVetSort(){
        return PacienteVetServicio.getPacienteVetSort();
    }
    
    @GetMapping("/{id}")
    public Optional<PacientevetModelo> getPacienteVetById(@PathVariable("id") String id){
        return PacienteVetServicio.getPacienteVetById(id);
    }

    //@GetMapping("/query") // ejemplo: http://localhost:8080/pacientevet/query?nickname=cocoliso
    //public List<adminModelo> getAdminsbyLastname(@RequestParam("lastname") String lastname){
        //return adminServicio.getAdminsbyLastname(lastname); 
    //}

    @PostMapping()
    public String savePacienteVet(@RequestBody PacientevetModelo PacienteVet){
        return PacienteVetServicio.guardarPacienteVet(PacienteVet);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteVetById(@PathVariable("id") String id){
       return PacienteVetServicio.eliminarPacienteVetPorId(id);
}
}
