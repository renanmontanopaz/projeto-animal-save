package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_associados", schema = "projeto-animal-save")
public class Associate extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O sobrenome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "sobrenome", length = 25, nullable = false)
    private String lastName;

    @Getter@Setter
    @Email
    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A senha deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "senha", length = 25, nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter @Setter
    @JoinColumn(name = "id_endereço", nullable = false)
    @ManyToOne
    private Address address;

    @Getter @Setter
    @Column(name = "aprovação", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter @Setter
    @JoinColumn(name = "id_ocorrência", nullable = false)
    @ManyToOne
    private Occurrences occurrences;

    @Getter @Setter
    @Column(name = "cargo", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
