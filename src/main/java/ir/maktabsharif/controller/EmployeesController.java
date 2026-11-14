package ir.maktabsharif.controller;

import ir.maktabsharif.dto.EmployeeDtoRequest;
import ir.maktabsharif.dto.EmployeeDtoResponse;
import ir.maktabsharif.exception.ServiceException;
import ir.maktabsharif.service.EmployeesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesServiceImpl service;

    public EmployeesController(EmployeesServiceImpl service) {
        this.service = service;
    }


    @GetMapping({"", "/"})
    public ResponseEntity<List<EmployeeDtoResponse>> findAll() {
        List<EmployeeDtoResponse> employeeDtoResponseList = service.findAll();
        if (employeeDtoResponseList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDtoResponseList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDtoResponse> findById(@PathVariable("id") Long id) {
        try {
            EmployeeDtoResponse employeeDtoResponse = service.findById(id);
            if (employeeDtoResponse == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employeeDtoResponse);
        } catch (ServiceException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping({"", "/"})
    public ResponseEntity<EmployeeDtoResponse> create(@Validated @RequestBody EmployeeDtoRequest employeeDtoRequest) {
        EmployeeDtoResponse employeeDtoResponse = service.save(employeeDtoRequest);
        if (employeeDtoResponse==null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDtoResponse>> findByFirstName(@RequestParam String firstName) {
        try {
            List<EmployeeDtoResponse> employeeDtoResponseList = service.findByFirstName(firstName);
            if (employeeDtoResponseList.isEmpty()) {

                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employeeDtoResponseList);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/byDepartment")
    public ResponseEntity<List<EmployeeDtoResponse>> findByDepartment(@RequestParam String byDepartment) {
        try {
            List<EmployeeDtoResponse> employeeDtoResponseList = service.findByDepartment(byDepartment);
            if (employeeDtoResponseList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employeeDtoResponseList);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/byEmail")
    public ResponseEntity<List<EmployeeDtoResponse>> findByEmail(@RequestParam String byEmail) {
        try {
            List<EmployeeDtoResponse> employeeDtoResponseList = service.findByEmail(byEmail);
            if (employeeDtoResponseList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employeeDtoResponseList);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
