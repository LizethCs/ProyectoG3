package backend_g3.demo.controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend_g3.demo.modelo.VeterinarioModelo;
import backend_g3.demo.servicio.VeterinarioServicio;


@RestController
@RequestMapping("/veterinario")

public class VeterinarioControlador {
    @Autowired
    VeterinarioServicio veterinarioServicio;
    
    //GetMapping asociado al servicio listar veterinarios
    @GetMapping()
    public List<VeterinarioModelo> getAllVeterinarios(){
        return veterinarioServicio.getAllVeterinarios();
    }

    //PostMapping asociado al servicio guardar veterinario
    @PostMapping()
    public VeterinarioModelo saveVeterinario(@RequestBody VeterinarioModelo veterinario){
        return veterinarioServicio.saveVeterinario(veterinario);
    }

    //GetMapping asociado al servicio buscar veterinario por id:
    @GetMapping("/{id}")
    public Optional<VeterinarioModelo> findVeterinarioById(@PathVariable("id") String id){
        return veterinarioServicio.getVeterinarioById(id);
    }
}
