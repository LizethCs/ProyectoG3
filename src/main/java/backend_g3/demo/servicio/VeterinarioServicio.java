package backend_g3.demo.servicio;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend_g3.demo.modelo.VeterinarioModelo;
import backend_g3.demo.repositorio.*;



@Service
public class VeterinarioServicio {
    @Autowired
     VeterinarioRepositorio veterinarioRepositorio;

    //servicio para listar todos los veterinarios:
    public List<VeterinarioModelo> getAllVeterinarios(){
        List<VeterinarioModelo> veterinarios= veterinarioRepositorio.findAll();
        veterinarios.sort((Comparator.comparing(VeterinarioModelo::getApellido))); //ordenamos por apellido
        return veterinarios;
    }

    //servicio para guardar veterinario:
    public VeterinarioModelo saveVeterinario(VeterinarioModelo veterinario){
        return veterinarioRepositorio.save(veterinario);
    }

    //servicio para buscar veterinario por id:
    public Optional<VeterinarioModelo> getVeterinarioById(String id){
        return veterinarioRepositorio.findById(id);
    }
}
