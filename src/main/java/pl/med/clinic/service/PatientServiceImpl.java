package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.controller.SimplePageForPagingAndSorting;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.repository.PatientRepository;

import javax.transaction.Transactional;

import static java.util.stream.Collectors.toList;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDtoResponse get(Long id) {
        return new PatientDtoResponse(patientRepository.getOrThrow(id));
    }

    @Override
    public SimplePageForPagingAndSorting<PatientDtoResponse> getAllPaged(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PatientEntity> pagedResult = patientRepository.findAll(paging);
        return new SimplePageForPagingAndSorting<>(pagedResult.getContent().stream()
                .map(PatientDtoResponse::new)
                .collect(toList()),
                pagedResult.getTotalElements(), paging);
    }

    @Override
    public PatientDtoResponse savePatient(PatientDtoRequest newPatient) {
        PatientEntity patientEntity = mapToEntity(newPatient);
        PatientEntity save = patientRepository.save(patientEntity);
        return new PatientDtoResponse(save);
    }

    @Override
    public PatientDtoResponse updatePatient(Long id, PatientDtoRequest updatedPatient) {
        PatientEntity patientById = patientRepository.getOrThrow(id);
        copyProperties(updatedPatient, patientById);
        PatientEntity updatedEntity = patientRepository.save(patientById);
        return new PatientDtoResponse(updatedEntity);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientEntity mapToEntity(PatientDtoRequest dto) {
        return new PatientEntity(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPesel(),
                dto.getGender(),
                dto.getDateOfBirth()
        );
    }
}
