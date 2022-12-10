package backend_g3.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("Pacientevet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacientevetModelo {
    @Id
    private String id_Pacientevet; //id de la mascota
    private String nickname; //Apodo o nombre de mascota
    private String OwnerName; //Nombre del dueño
    private String OwnerLastname; //apellido del dueño
    
}
