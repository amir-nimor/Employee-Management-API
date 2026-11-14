package ir.maktabsharif.command;

import ir.maktabsharif.dto.EmployeeDtoRequest;
import ir.maktabsharif.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestToDao {
    Employee convert(EmployeeDtoRequest employeeDtoRequest);
}
