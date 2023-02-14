package pl.med.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.med.clinic.entity.Procedure;

import java.util.List;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {

    @Query("SELECT p FROM Procedure p WHERE p.chapter LIKE %:q% OR p.detailedCategory LIKE %:q%")
    List<Procedure> search(String q);

}
