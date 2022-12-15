package backend_g3.demo.controlador;

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
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMethod;
import backend_g3.demo.modelo.adminModelo;
import backend_g3.demo.servicio.adminServicio;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })

public class adminControlador {
    @Autowired
    adminServicio adminServicio;

    @GetMapping()
    public List<adminModelo> getAllAdmnisSort() {
        return adminServicio.getAdminsSort();
    }

    @GetMapping("/{id}")
    public Optional<adminModelo> getAdminById(@PathVariable("id") String id) {
        return adminServicio.getAdminById(id);
    }

    @GetMapping("/query") // ejemplo: http://localhost:8080/pacientes/query?lastname=mejia
    public List<adminModelo> getAdminsbyLastname(@RequestParam("lastname") String lastname) {
        return adminServicio.getAdminsbyLastname(lastname);
    }

    @PostMapping()
    public String saveAdmin(@RequestBody adminModelo admin) {
        return adminServicio.guardarAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdminById(@PathVariable("id") String id) {
        return adminServicio.eliminarAdminPorId(id);
    }
}