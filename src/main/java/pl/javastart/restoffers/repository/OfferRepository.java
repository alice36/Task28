package pl.javastart.restoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.restoffers.model.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("SELECT o from Offer o " +
            "where o.title like :letter%")
    List<Offer> findOfferByNamePart(@Param("letter") String letter);

    @Query("SELECT o from Offer o " +
            "where o.id = :letter")
    Offer findOfferUsingId(@Param("letter") Long id);
}
