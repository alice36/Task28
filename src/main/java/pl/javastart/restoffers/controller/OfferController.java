package pl.javastart.restoffers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private OfferRepository offerRepository;

    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping
    public List<Offer> getAllOffers(@RequestParam(required = false) String title) {
        if (title==null) {
            return offerRepository.findAll();
        } else {
            return offerRepository.findOfferByNamePart(title);
        }
    }

    @GetMapping("/count")
    public long countOffers() {
        return offerRepository.count();
    }

    @PostMapping
    public ResponseEntity saveOffer(@RequestBody Offer offer){
        offerRepository.save(offer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable("id") Long id){

        Optional<Offer> byId = offerRepository.findById(id);
        if(byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOffer(@PathVariable("id") Long id){

        Optional<Offer> byId = offerRepository.findById(id);
        if(byId.isPresent()) {
            offerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return  ResponseEntity.notFound().build();
    }

}

