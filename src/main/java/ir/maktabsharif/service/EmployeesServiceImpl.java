package ir.maktabsharif.service;

import ir.maktabsharif.command.DaoToResponse;
import ir.maktabsharif.command.RequestToDao;
import ir.maktabsharif.dto.EmployeeDtoRequest;
import ir.maktabsharif.dto.EmployeeDtoResponse;
import ir.maktabsharif.exception.ServiceException;
import ir.maktabsharif.model.Employee;
import ir.maktabsharif.repository.EmploeesRepositoryImpl;
import ir.maktabsharif.repository.EmployeeRepository;
import ir.maktabsharif.util.Ruls;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeeRepository employeeRepository;
    private final EmploeesRepositoryImpl emploeesRepositoryimpl;
    private final DaoToResponse daoToResponse;
    private final RequestToDao requestToDao;

    public EmployeesServiceImpl(EmployeeRepository employeeRepository, EmploeesRepositoryImpl emploeesRepository, DaoToResponse daoToResponse, RequestToDao requestToDao) {
        this.employeeRepository = employeeRepository;
        this.emploeesRepositoryimpl = emploeesRepository;
        this.daoToResponse = daoToResponse;
        this.requestToDao = requestToDao;
    }

    private void validation(EmployeeDtoRequest employeeDtoRequest) {
        Ruls.check(employeeDtoRequest.getFirstName().isBlank(), "your firstname is empty");
        Ruls.check(employeeDtoRequest.getLastName().isBlank(), "your LastName is empty");
        Ruls.check(employeeDtoRequest.getEmail().isBlank(), "your email is empty");
        Ruls.check(employeeDtoRequest.getDepartment().isBlank(), "your department is empty");
        Ruls.check(employeeDtoRequest.getSalary() < 0, "your salary is negative");
    }

    @Override
    public EmployeeDtoResponse save(EmployeeDtoRequest employeeDtoRequest) {
        try {
            validation(employeeDtoRequest);
            return Optional.ofNullable(daoToResponse.convert(employeeRepository.save(requestToDao.convert(employeeDtoRequest)))).orElse(null);
        } catch (ValidationException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            emploeesRepositoryimpl.delete(id);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public EmployeeDtoResponse findById(Long id) {
        try {
            return Optional.ofNullable(daoToResponse.convert(employeeRepository.findById(id).get())).orElse(null);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<EmployeeDtoResponse> findAll() {
        try {
            return Optional.ofNullable(employeeRepository.findAll().stream().map(e -> daoToResponse.convert(e)).toList()).orElse(null);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<EmployeeDtoResponse> findByFirstName(String firstName) {
        try {
            return Optional.ofNullable(employeeRepository.findByFirstName(firstName).stream().map(e -> daoToResponse.convert(e)).toList()).orElse(null);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<EmployeeDtoResponse> findByDepartment(String department) {
        try {
            return Optional.ofNullable(employeeRepository.findByDepartment(department).stream().map(e -> daoToResponse.convert(e)).toList()).orElse(null);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<EmployeeDtoResponse> findByEmail(String email) {
        try {
            return Optional.ofNullable(employeeRepository.findByEmail(email).stream().map(e -> daoToResponse.convert(e)).toList()).orElse(null);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public EmployeeDtoResponse update(EmployeeDtoRequest employeeDtoRequest, Long id) {
        try {
            Employee employee = requestToDao.convert(employeeDtoRequest);
            return daoToResponse.convert(emploeesRepositoryimpl.update(employee,id));
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
