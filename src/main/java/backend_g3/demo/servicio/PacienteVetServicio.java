package backend_g3.demo.servicio;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import backend_g3.demo.modelo.PacientevetModelo;
import backend_g3.demo.repositorio.PacienteVetRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Comparator;


@Service
public class PacienteVetServicio {
@Autowired
PacienteVetRepositorio PacienteRep;

    public List<PacientevetModelo> getPacienteVetSort() {
        List<PacientevetModelo> listPacientes = PacienteRep.findAll();
        listPacientes.sort(Comparator.comparing(PacientevetModelo::getNickname));
        return listPacientes;
    }

  

    public Optional<PacientevetModelo> getPacienteVetById(String id) {
        return PacienteRep.findById(id);
    }

    
    public String guardarPacienteVet(PacientevetModelo pacienteVet) {
         pacienteVet.setNickname(pacienteVet.getNickname().toLowerCase());
          pacienteVet.setOwnerLastname(pacienteVet.getOwnerLastname().toLowerCase());
         pacienteVet.setOwnerName(pacienteVet.getOwnerName().toLowerCase());

          boolean estado = pacienteVet.getId_Pacientevet() == null || !PacienteRep.existsById(pacienteVet.getId_Pacientevet());
          PacienteRep.save(pacienteVet);
           if (estado) {
                return "Se guardó el paciente";
             } else {
               return "Se actualizó el paciente";
           }
    }

    public String eliminarPacienteVetPorId(String id) {
          if (PacienteRep.existsById(id)) {
            Optional<PacientevetModelo> paciente = PacienteRep.findById(id);
         PacienteRep.deleteById(id);
         return "Paciente " + paciente.get().getNickname() + " eliminado";
   } else {
         return "No Eliminado";
     }
 }
    }
    


