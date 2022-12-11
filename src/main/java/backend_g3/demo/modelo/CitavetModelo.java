package backend_g3.demo.modelo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("citavet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CitavetModelo {
    @Id
    private String id;
    private String id_veterinario;
    private String nombreveterinario;
    private LocalDate fecha; //posibles fechas
    private List<Object> citas; //{id del paciente, fecha y hora de la cita, recomendacion}
}
