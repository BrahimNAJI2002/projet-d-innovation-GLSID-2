package ma.enset.projetdinnovationglsid.web;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.*;
import ma.enset.projetdinnovationglsid.services.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientRestAPI {
    private PatientService patientService;

    public PatientRestAPI(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{patientId}")
    public PatientDto getPatient(@PathVariable Long patientId) throws PatientNotFoundException {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/patients")
    public List<PatientDto> listPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping("/patients")
    public PatientDto createPatient(@RequestBody PatientDto patientDto){
        return patientService.createPatient(patientDto);
    }

    @PutMapping("/patients/{patientId}")
    public PatientDto updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto) throws PatientNotFoundException {
        return patientService.updatePatient(patientId, patientDto);
    }

    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientService.deletePatient(patientId);
    }

    @GetMapping("/patients/search")
    public List<PatientDto> searchPatients(@RequestParam String searchTerm) {
        return patientService.searchPatients(searchTerm);
    }
}