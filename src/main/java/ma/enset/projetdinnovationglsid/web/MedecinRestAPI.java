package ma.enset.projetdinnovationglsid.web;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.*;
import ma.enset.projetdinnovationglsid.services.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MedecinRestAPI {
    private MedecinService medecinService;

    public MedecinRestAPI(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @GetMapping("/medecins/{medecinId}")
    public MedecinDto getMedecin(@PathVariable Long medecinId) throws MedecinNotFoundException {
        return medecinService.getMedecinById(medecinId);
    }

    @GetMapping("/medecins")
    public List<MedecinDto> listMedecins(){
        return medecinService.getAllMedecins();
    }

    @PostMapping("/medecins")
    public MedecinDto createMedecin(@RequestBody MedecinDto medecinDto){
        return medecinService.createMedecin(medecinDto);
    }

    @PutMapping("/medecins/{medecinId}")
    public MedecinDto updateMedecin(@PathVariable Long medecinId, @RequestBody MedecinDto medecinDto) throws MedecinNotFoundException {
        return medecinService.updateMedecin(medecinId, medecinDto);
    }

    @DeleteMapping("/medecins/{medecinId}")
    public void deleteMedecin(@PathVariable Long medecinId){
        medecinService.deleteMedecin(medecinId);
    }

    @GetMapping("/medecins/search")
    public List<MedecinDto> searchMedecins(@RequestParam(name = "searchTerm",defaultValue = "") String searchTerm) {
        return medecinService.searchMedecins("%"+searchTerm+"%");
    }
}
