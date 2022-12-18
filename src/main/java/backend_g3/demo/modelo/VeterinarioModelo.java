package backend_g3.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("veterinario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VeterinarioModelo {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private long ntarjetaprof;
    private Object cuenta; //ejemplo cuenta: {"emai": "cuenta@veterinaria.com", "password": "juanse1421"}
}
