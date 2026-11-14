package ir.maktabsharif.command;

import ir.maktabsharif.dto.EmployeeDtoResponse;
import ir.maktabsharif.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DaoToResponse {
    EmployeeDtoResponse convert(Employee employee);
}
