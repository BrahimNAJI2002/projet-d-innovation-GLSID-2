package ma.enset.projetdinnovationglsid.web;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.*;
import ma.enset.projetdinnovationglsid.services.*;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RendezVousRestAPI {
    private RendezVousService rendezVousService;

    public RendezVousRestAPI(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @GetMapping("/rendezvous/{rendezVousId}")
    public RendezVousDto getRendezVous(@PathVariable Long rendezVousId) throws RendezVousNotFoundException {
        return rendezVousService.getRendezVousById(rendezVousId);
    }

    @GetMapping("/rendezvous")
    public List<RendezVousDto> listRendezVous(){
        return rendezVousService.getAllRendezVous();
    }

    @PostMapping("/rendezvous")
    public RendezVousDto createRendezVous(@RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.createRendezVous(rendezVousDto);
    }

    @PutMapping("/rendezvous/{rendezVousId}")
    public RendezVousDto updateRendezVous(@PathVariable Long rendezVousId, @RequestBody RendezVousDto rendezVousDto) throws RendezVousNotFoundException {
        return rendezVousService.updateRendezVous(rendezVousId, rendezVousDto);
    }

    @DeleteMapping("/rendezvous/{rendezVousId}")
    public void deleteRendezVous(@PathVariable Long rendezVousId){
        rendezVousService.deleteRendezVous(rendezVousId);
    }

    @GetMapping("/rendezvous/search")
    public List<RendezVousDto> searchRendezVous(@RequestParam Date date) {
        return rendezVousService.searchRendezVous(date);
    }
}
