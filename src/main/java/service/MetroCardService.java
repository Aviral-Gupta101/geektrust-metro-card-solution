package service;

import Entity.MetroCard;
import repository.MetroCardRepository;
import repository.MetroCardRepositoryImpl;
import java.util.Optional;

public class MetroCardService {

    private static final MetroCardRepository repo = new MetroCardRepositoryImpl();

    public void createMetroCard(String id, int balance) {
        repo.saveCard(new MetroCard(id, balance));
    }

    public MetroCard createMetroCard(MetroCard metroCard) {
        return repo.saveCard(metroCard);
    }

    public int getBalance(String cardId){
        Optional<MetroCard> metroCardOptional = repo.findById(cardId);

        if(!metroCardOptional.isPresent())
            throw new RuntimeException("MetroCard not found, cannot get the balance");

        return metroCardOptional.get().getBalance();

    }

    public void withdraw(String cardId, int withdrawalAmount) {

        Optional<MetroCard> metroCardOptional = repo.findById(cardId);

        if(!metroCardOptional.isPresent())
            throw new RuntimeException("MetroCard not found, cannot withdraw");

        metroCardOptional.get().withdraw(withdrawalAmount);
    }

    public void resetBalance(String cardId){

        Optional<MetroCard> metroCardOptional = repo.findById(cardId);

        if(!metroCardOptional.isPresent())
            throw new RuntimeException("MetroCard not found, cannot withdraw");

        metroCardOptional.get().setBalance(0);
    }

}
