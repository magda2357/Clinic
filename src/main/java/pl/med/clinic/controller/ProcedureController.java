package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.med.clinic.dto.FileUploadResponse;
import pl.med.clinic.dto.ProcedureDtoResponse;
import pl.med.clinic.file.FileUploadUtil;
import pl.med.clinic.service.ProcedureService;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/procedure")
public class ProcedureController {

    public final ProcedureService procedureService;

    @GetMapping
    public List<ProcedureDtoResponse> search(String q) {
        return procedureService.search(q);
    }

    @PostMapping(value = "/uploadFile", consumes = {"multipart/form-data"})
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws Exception {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        long size = multipartFile.getSize();
        String extension = FileNameUtils.getExtension(multipartFile.getOriginalFilename());

        if(size > 3000000) {
            throw new Exception("File size should be less than 3MB");
        }
        if(!(extension.equals("xls")||extension.equals("xlsx"))) {
            throw new Exception("File type not supported");
        }

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


