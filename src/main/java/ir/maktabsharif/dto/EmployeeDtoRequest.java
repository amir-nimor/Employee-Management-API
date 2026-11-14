package ir.maktabsharif.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDtoRequest {

    @NotNull @NotBlank @NotEmpty
    private String firstName;

    @NotNull @NotBlank @NotEmpty
    private String lastName;

    @NotNull @NotBlank @NotEmpty
    private String email;

    @NotNull @NotBlank @NotEmpty

    private String department;

    private Double salary;

}
