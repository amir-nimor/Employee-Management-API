package ir.maktabsharif.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDtoResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private Double salary;

}
