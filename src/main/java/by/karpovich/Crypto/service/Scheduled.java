package by.karpovich.Crypto.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduled {

//    private final CryptoServiceImpl cryptoService;
//
//    private void updatePrice() {
//        cryptoService.updateCryptoEntities();
//    }
//
//    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//
//    @PostConstruct
//    public void startUpdating() {
//        executorService.scheduleAtFixedRate(this::updatePrice, 0, 1, TimeUnit.MINUTES);
//    }
//
//    @PreDestroy
//    public void stopUpdating() {
//        executorService.shutdown();
//    }
}