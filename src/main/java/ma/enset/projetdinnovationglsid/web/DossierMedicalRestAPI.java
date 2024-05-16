package ma.enset.projetdinnovationglsid.web;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.*;
import ma.enset.projetdinnovationglsid.services.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DossierMedicalRestAPI {
    private DossierMedicalService dossierMedicalService;

    public DossierMedicalRestAPI(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }

    @GetMapping("/dossiers-medicaux/{dossierMedicalId}")
    public DossierMedicalDto getDossierMedical(@PathVariable Long dossierMedicalId) throws DossierMedicalNotFoundException {
        return dossierMedicalService.getDossierMedicalById(dossierMedicalId);
    }

    @GetMapping("/dossiers-medicaux")
    public List<DossierMedicalDto> listDossiersMedical(){
        return dossierMedicalService.getAllDossiersMedical();
    }

    @PostMapping("/dossiers-medicaux")
    public DossierMedicalDto createDossierMedical(@RequestBody DossierMedicalDto dossierMedicalDto){
        return dossierMedicalService.createDossierMedical(dossierMedicalDto);
    }

    @PutMapping("/dossiers-medicaux/{dossierMedicalId}")
    public DossierMedicalDto updateDossierMedical(@PathVariable Long dossierMedicalId, @RequestBody DossierMedicalDto dossierMedicalDto) throws DossierMedicalNotFoundException {
        return dossierMedicalService.updateDossierMedical(dossierMedicalId, dossierMedicalDto);
    }

    @DeleteMapping("/dossiers-medicaux/{dossierMedicalId}")
    public void deleteDossierMedical(@PathVariable Long dossierMedicalId){
        dossierMedicalService.deleteDossierMedical(dossierMedicalId);
    }

    @GetMapping("/dossiers-medicaux/search")
    public List<DossierMedicalDto> searchDossiersMedical(@RequestParam String searchTerm) {
        return dossierMedicalService.searchDossiersMedical(searchTerm);
    }
}
