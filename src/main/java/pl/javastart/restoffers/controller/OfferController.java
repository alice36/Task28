package pl.javastart.restoffers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;

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
        if (id >= offerRepository.findAll().size())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(offerRepository.findOfferUsingId(id));
    }

}

