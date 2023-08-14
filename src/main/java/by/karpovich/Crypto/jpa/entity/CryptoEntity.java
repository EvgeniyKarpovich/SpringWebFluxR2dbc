package by.karpovich.Crypto.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cryptos")
public class CryptoEntity {

    @Id
    private Long id;
    @Column
    private String idFromCoinLore;
    @Column
    private String name;
    @Column
    private String symbol;
    @Column
    private Integer rank;
    @Column
    private String priceInUSD;
    @Column
    private String percentChange24h;
    @Column
    private String percentChange1h;
    @Column
    private String percentChange7d;
    @Column
    private Instant dateOfCreation;
    @Column
    private Instant dateOfChange;
}
