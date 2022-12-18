package backend_g3.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class adminModelo {
    @Id
    private String id_admin;
    private String email;
    private String password;
    private String name;
    private String lastname;
}