package ir.maktabsharif.repository;

import ir.maktabsharif.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByDepartment(String department);

    @Query("select e FROM Employee e where e.email = :email")
    List<Employee> findByEmail(String email);

}
