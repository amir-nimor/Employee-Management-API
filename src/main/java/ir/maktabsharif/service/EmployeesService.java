package ir.maktabsharif.service;

import ir.maktabsharif.dto.EmployeeDtoRequest;
import ir.maktabsharif.dto.EmployeeDtoResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeesService {


    EmployeeDtoResponse save(EmployeeDtoRequest employeeDtoRequest);

    void delete(Long id);

    EmployeeDtoResponse findById(Long id);

    List<EmployeeDtoResponse> findAll();

    List<EmployeeDtoResponse> findByFirstName(String firstName);

    List<EmployeeDtoResponse> findByDepartment(String department);

    List<EmployeeDtoResponse> findByEmail(String email);




}
