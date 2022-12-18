package backend_g3.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//la primera anotación que hago es que este es un documento:

@Document("pacientevet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PacientevetModelo {
    @Id
    private String id;
    private String nombremascota;
    private String mascota;
    private String raza;
    private String edad;
    private List<String> enfermedades; //ej:["moquillo","rabia"]
    private Object propietario; //ej: propietario:{nombre:" ",apellido:" ",direccion:" ",telefono:" ",ndocumento: " "}
}
