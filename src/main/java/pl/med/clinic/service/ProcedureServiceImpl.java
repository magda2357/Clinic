package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.ProcedureDtoResponse;
import pl.med.clinic.repository.ProcedureRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ProcedureServiceImpl implements ProcedureService {

    public final ProcedureRepository procedureRepository;

    @Override
    public List<ProcedureDtoResponse> search(String q) {
        return procedureRepository.search(q).stream()
                .map(ProcedureDtoResponse::new)
                .collect(Collectors.toList());
    }
}
