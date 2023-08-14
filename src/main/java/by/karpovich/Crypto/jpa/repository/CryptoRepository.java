package by.karpovich.Crypto.jpa.repository;

import by.karpovich.Crypto.jpa.entity.CryptoEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository extends R2dbcRepository<CryptoEntity, Long> {

    Optional<CryptoEntity> findByName(String name);

//    @Query("SELECT c FROM CryptoEntity c WHERE c.idFromCoinLore = (SELECT MAX(c2.idFromCoinLore) FROM CryptoEntity c2)")
//    CryptoEntity findCryptoEntityWithMaxIdFromCoinLore();

    @Query("SELECT MAX(idFromCoinLore) FROM CryptoEntity")
    String findMaxIdFromCoinLoreFromCryptoEntity();

    Optional<CryptoEntity> findByIdFromCoinLore(String id);
}
