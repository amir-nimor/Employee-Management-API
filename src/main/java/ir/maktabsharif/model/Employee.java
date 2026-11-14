package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "employees")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee extends BaseModel<Long> {

    @NotNull @NotBlank @NotEmpty
    @Column(nullable = false,name = "first_name")
    private String firstName;

    @NotNull @NotBlank @NotEmpty
    @Column(nullable = false,name = "last_name")
    private String lastName;

    @NotNull @NotBlank @NotEmpty
    @Column(nullable = false)
    private String email;

    @NotNull @NotBlank @NotEmpty
    @Column(nullable = false)
    private String department;

    private Double salary;
}
