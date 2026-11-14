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
}
