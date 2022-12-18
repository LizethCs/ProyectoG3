package backend_g3.demo.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import backend_g3.demo.modelo.PacientevetModelo;
import backend_g3.demo.servicio.PacientevetServicio;



@RestController
@RequestMapping("/pacientevet")
@CrossOrigin(origins = "*" , methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})

//microservicio para el paciente veterinario
public class PacienteVetControlador {
    @Autowired
    PacientevetServicio pacientevetServicio;
    
    //Get mapping asociado al servicio para ordenar alfabeticamente los nombres
    @GetMapping()
    public List<PacientevetModelo> getAllPacientevetOrden(){
        return pacientevetServicio.getListPacientevetOrden();
    }

    //Get mapping asociado al servicio buscar paciente por id:
    @GetMapping("/{id}") 
    public Optional<PacientevetModelo> findPacientevetByID(@PathVariable("id")String id){
        return pacientevetServicio.getPacientevetById(id);
    }

    //Get mapping asociado al servicio buscar paciente por nombre:
    @GetMapping("/query")    //ejemplo: http://localhost:8080/pacientevet/query?
    public List<PacientevetModelo> getPacientevetByNombremascota(@RequestParam("nombremascota")String nombremascota){
        return pacientevetServicio.getPacientevetByNombremascota(nombremascota);
    }

    //Get mapping asociado al servicio buscar tipo mascota
    @GetMapping("/mascota/query")  //ejemplo: http://localhost:8080/pacientevet/mascota/query?mascota=perro
    public List<PacientevetModelo> getPacienteByMascota(@RequestParam("mascota")String mascota){
        return pacientevetServicio.getPacienteByMascota(mascota);
    }
    
    @PostMapping
    public void savePacientevet(@RequestBody PacientevetModelo paciente){
         pacientevetServicio.guardarPacientevet(paciente);
    }

    //Delete maping asociado al servicio eliminar paciente veterinaria por id
    @DeleteMapping("/{id}")
    public String deletePacientevetById(@PathVariable("id")String id){
        return pacientevetServicio.eliminarPacientevetPorId(id);
    }
    
    //Get mapping asociado al servicio buscar por nombre del propietario
    @GetMapping("/nombre/{nombre}")
    public List<PacientevetModelo> listPacientevetNombre(@PathVariable("nombre")String nombre){
        return pacientevetServicio.pacientevetByNombre(nombre);
    }
    
    //Get mapping asociado al servicio buscar por telefono del propietario
    @GetMapping("/telefono/{telefono}")
    public List<PacientevetModelo> listPacientevetTelefono(@PathVariable("telefono")String telefono){
        return pacientevetServicio.pacientevetByTelefono(telefono);
    }
    
}
