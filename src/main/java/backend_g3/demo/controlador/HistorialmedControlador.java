package backend_g3.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import backend_g3.demo.modelo.HistorialmedModelo;
import backend_g3.demo.servicio.HistorialmedServicio;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/historialmed")
@CrossOrigin(origins = "*" , methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class HistorialmedControlador {
    @Autowired
    HistorialmedServicio historialmedServicio;

    //Getmapping asociado al servicio listar historiales medicos:
    @GetMapping()
    public List<HistorialmedModelo> getAllHistorialmed(){
        return historialmedServicio.getAllHistorialmed();
    }

    //Postmapping asociado al servicio guardar historial medico
    @PostMapping()
    public HistorialmedModelo saveHistorialmed(@RequestBody HistorialmedModelo historialmed){
        return historialmedServicio.saveHistorialmed(historialmed);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String id) {
        return historialmedServicio.eliminarPorId(id);
    }
   
}
