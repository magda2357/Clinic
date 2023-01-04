package pl.med.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.med.clinic.entity.VisitEntity;
import pl.med.clinic.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    List<VisitEntity> getVisitEntitiesByPatientId(Long patientId);

    default VisitEntity getOrThrow(Long id) {
        Optional<VisitEntity> optionalVisitEntity = findById(id);
        return optionalVisitEntity
                .orElseThrow(() -> new EntityNotFoundException("Visit no: " + id + " not found"));
    }
}
