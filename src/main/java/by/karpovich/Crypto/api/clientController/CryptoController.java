package by.karpovich.Crypto.api.clientController;

import by.karpovich.Crypto.api.dto.crypto.CoinListResponse;
import by.karpovich.Crypto.api.dto.crypto.CoinResult;
import by.karpovich.Crypto.jpa.entity.CryptoEntity;
import by.karpovich.Crypto.service.CryptoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/cryptos")
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoServiceImpl cryptoService;

//    @PostMapping
//    public void save() {
//        cryptoService.saveResult();
//    }

//    @PutMapping
//    public void update() {
//        cryptoService.updateCoins();
//    }

    @PostMapping(value = "/test"/*, produces = MediaType.APPLICATION_NDJSON_VALUE*/)
    public Flux<CryptoEntity> cryptoEntity() {
       return   cryptoService.test();
    }

    @GetMapping(value = "/test1", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<CoinListResponse> cryptoEntity111() {
        return cryptoService.test1();
    }
}
