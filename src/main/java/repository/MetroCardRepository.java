package repository;

import Entity.MetroCard;

import java.util.Optional;

public interface MetroCardRepository {
    
    MetroCard saveCard(MetroCard metroCard);

    Optional<MetroCard> findById(String cardId);

    void clearRepository();
}
