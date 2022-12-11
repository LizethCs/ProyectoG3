package backend_g3.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("historialmed")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HistorialmedModelo {
    @Id
    private String id;
    private String nombremascota;
    private List<String> vacunas;
    private List<String> intervenciones; //ej:[cirugia de displasia, tratamiento homeopatico]
    private Object valoracioninicial; //ej:{peso:15 libras,alturamedia:  ,promediovida: ,caracteristicas: }
}
