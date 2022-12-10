package backend_g3.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import backend_g3.demo.modelo.adminModelo;
import backend_g3.demo.repositorio.adminRepositorio;

@Service
public class adminServicio{
    @Autowired
    adminRepositorio adminRepo;

    public String guardarAdmin(adminModelo admin) {
        admin.setName(admin.getName().toLowerCase());
        admin.setLastname(admin.getLastname().toLowerCase());
        boolean estado=admin.getId_admin() == null || !adminRepo.existsById(admin.getId_admin());
        adminRepo.save(admin);
        if (estado) {
            return "Se guardó el administrador";
        } else {
            return "Se actualizó el administrador";
        }
    }

    public List<adminModelo> getAdminsSort() {
        List<adminModelo> listAdmins = adminRepo.findAll();
        listAdmins.sort(Comparator.comparing(adminModelo::getName));
        return listAdmins;
    }

    public Optional<adminModelo> getAdminById(String id) {
        return adminRepo.findById(id);
    }

    public List<adminModelo> getAdminsbyLastname(String lastname){
        return adminRepo.findByLastname(lastname);
    }

       public String eliminarAdminPorId(String id) {
        if (adminRepo.existsById(id)) {
            Optional<adminModelo> admin = adminRepo.findById(id);
            adminRepo.deleteById(id);
            return "Admin " + admin.get().getName() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }
}