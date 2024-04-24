package id.ac.ui.cs.advprog.koleksikota.authentication.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table
public class User {

    @Id
    private Long id;
    private String email;
    private String password;
}
