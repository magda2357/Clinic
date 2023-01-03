package pl.med.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.med.clinic.entity.VisitEntity;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    List<VisitEntity> getVisitEntitiesByPatientId(Long patientId);

}
