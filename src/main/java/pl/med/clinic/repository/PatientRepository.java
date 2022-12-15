package pl.med.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.exception.NotFoundException;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    default PatientEntity getOrElseThrow(Long id) {
        Optional<PatientEntity> optionalPatientEntity = findById(id);
        return optionalPatientEntity.orElseThrow(() -> new NotFoundException("Entity not found"));
    }
}
