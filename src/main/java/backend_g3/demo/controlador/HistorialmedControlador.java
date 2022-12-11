package backend_g3.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend_g3.demo.modelo.HistorialmedModelo;
import backend_g3.demo.servicio.HistorialmedServicio;



@RestController
@RequestMapping("/historialmed")
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
   
}
