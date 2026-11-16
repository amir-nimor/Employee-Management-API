package ir.maktabsharif.repository;

import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmploeesRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void delete(Long id){
        Employee employee = entityManager.find(Employee.class,id);
        if (employee==null){
            throw new RepositoryException("your entity not founded");
        }
        entityManager.remove(employee);
    }



    @Transactional
    public Employee update(Employee employee,Long id){
        Employee employeeFind = entityManager.find(Employee.class,id);
        if (employee==null){
            throw new RepositoryException("your entity not founded");
        }
        employeeFind.setDepartment(employee.getDepartment());
        employeeFind.setEmail(employee.getEmail());
        employeeFind.setFirstName(employee.getFirstName());
        employeeFind.setLastName(employee.getLastName());

        return employeeFind;
    }
}
