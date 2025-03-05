package repository;

import Entity.MetroCard;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MetroCardRepositoryImpl implements MetroCardRepository {

    private static final Map<String, MetroCard> metroCardMap = new HashMap<>();

    @Override
    public MetroCard saveCard(MetroCard metroCard) {
        metroCardMap.put(metroCard.getCardId(), metroCard);
        return metroCard;
    }

    @Override
    public Optional<MetroCard> findById(String cardId) {
        MetroCard result = metroCardMap.get(cardId);

        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(result);
    }

}
