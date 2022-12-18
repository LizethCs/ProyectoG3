package backend_g3.demo.servicio;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend_g3.demo.modelo.PacientevetModelo;
import backend_g3.demo.repositorio.*;


@Service
public class PacientevetServicio {
    @Autowired
    PacientevetRepositorio pacientevetRepositorio;

    //servicio para guardar paciente veterinario (pasar nombre, mascota y raza)
    public String guardarPacientevet(PacientevetModelo pacientevet){
        pacientevet.setNombremascota(pacientevet.getNombremascota().toLowerCase());
        pacientevet.setMascota(pacientevet.getMascota().toLowerCase());
        pacientevet.setRaza(pacientevet.getRaza().toLowerCase());
        boolean estado= pacientevet.getId() == null || !pacientevetRepositorio.existsById(pacientevet.getId());
        //validar si el paciente veterinario que nos mandan guardar viene con un id o no
        if(estado){
            return "Se guardó el paciente.";
        }else{
            return "Se actualizó el paciente.";
        }
    }

    //servicio para ordenar alfabeticamente los nombres de los pacientes:
    public List<PacientevetModelo> getListPacientevetOrden(){
        List<PacientevetModelo> listaPacientevet = pacientevetRepositorio.findAll();
        listaPacientevet.sort(Comparator.comparing(PacientevetModelo::getNombremascota));
        //listaPacientevet.sort(Comparator.comparing(PacientevetModelo::getMascota));
        return listaPacientevet;
    }

    //Servicio para buscar paciente por id (optional: bien podemos recibir algun tipo de dato especificado o null )
    public Optional<PacientevetModelo> getPacientevetById(String id){
        return pacientevetRepositorio.findById(id);
    }

    //servcio para buscar pacientes veterinarios por nombre mascota
    public List<PacientevetModelo> getPacientevetByNombremascota(String nombremascota){
        return pacientevetRepositorio.findByNombremascota(nombremascota);
    }

    //servicio para buscar paciente veterinario por tipo mascota
    public List<PacientevetModelo> getPacienteByMascota(String mascota){
        return pacientevetRepositorio.findByMascota(mascota);
    }
    
    //servicio para eliminar paciente veterinario por id:
    public String eliminarPacientevetPorId(String id){
        if(pacientevetRepositorio.existsById(id)){
            Optional<PacientevetModelo> pacientevet = pacientevetRepositorio.findById(id);
            pacientevetRepositorio.deleteById(id);
            return "Paciente"+ pacientevet.get().getNombremascota() +"eliminado.";
        }else{
            return "No eliminado.";
        }
    }

    //servicio para buscar por nombre del propietario:
    public List<PacientevetModelo> pacientevetByNombre(String nombre){
        return pacientevetRepositorio.buscarPorNombre(nombre);
    }

    //servicio para buscar por telefono del propietario:
    public List<PacientevetModelo> pacientevetByTelefono(String telefono){
        return pacientevetRepositorio.buscarPorTelefono(telefono);
    }
}
