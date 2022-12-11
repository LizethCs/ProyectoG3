package backend_g3.demo.servicio;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend_g3.demo.modelo.HistorialmedModelo;
import backend_g3.demo.repositorio.*;


@Service
public class HistorialmedServicio {
    @Autowired
    HistorialmedRepositorio historialmedRepositorio;
    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    //servicio para listar todos los historiales medicos
    public List<HistorialmedModelo> getAllHistorialmed(){
        List<HistorialmedModelo> historialmed=historialmedRepositorio.findAll();
        historialmed.sort((Comparator.comparing(HistorialmedModelo::getNombremascota))); //ordenamos por nombre mascota
        return historialmed;
    }

    //servicio para guardar historial medico
    public HistorialmedModelo saveHistorialmed(HistorialmedModelo historialmed){
        return historialmedRepositorio.save(historialmed);
    }
    

}
