package by.karpovich.Crypto.service;

import by.karpovich.Crypto.api.dto.crypto.CoinListResponse;
import by.karpovich.Crypto.jpa.entity.CryptoEntity;
import by.karpovich.Crypto.jpa.repository.CryptoRepository;
import by.karpovich.Crypto.mapping.CryptoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoServiceImpl {

    private final CryptoRepository cryptoRepository;
    private final CryptoMapper cryptoMapper;

//    public void saveResult() {
//        int start = 0;
//        int limit = 100;
//
//        OkHttpClient client = new OkHttpClient();
//        Gson gson = new Gson();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        while (true) {
//            String url = "https://api.coinlore.net/api/tickers/?start=" + start + "&limit=" + limit;
//
//            String response = sendGetRequest(client, url);
//
//            try {
//                CoinListResponse coinListResponse = gson.fromJson(response, CoinListResponse.class);
//                List<CoinDto> coinsDtoFromCoinLore = coinListResponse.getData();
//
//                if (coinsDtoFromCoinLore.isEmpty() ) {
//                    break;
//                }
//
//                executorService.execute(() -> saveCoins(coinsDtoFromCoinLore));
//
//                if (coinsDtoFromCoinLore.size() < limit) {
//                    break;
//                }
//
//                start += limit;
//            } catch (JsonSyntaxException e) {
//                e.printStackTrace();
//            }
//        }
//
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(2, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    @Transactional
//    private void saveCoins(List<CoinDto> coinsDto) {
//        List<CryptoEntity> cryptoEntities = new ArrayList<>();
//
//        for (CoinDto coinDto : coinsDto) {
//            CryptoEntity cryptoEntity = cryptoMapper.mapCryptoEntityFromCoinDto(coinDto);
//            cryptoEntities.add(cryptoEntity);
//        }
//
//        cryptoRepository.saveAll(cryptoEntities);
//    }
//
//    private String sendGetRequest(OkHttpClient client, String url) {
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (response.isSuccessful()) {
//                ResponseBody responseBody = response.body();
//                if (responseBody != null) {
//                    return responseBody.string();
//                }
//            } else {
//                // Обработка ошибки, если требуется
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    ///// TEST
//    public void saveResult() {
//        int start = 0;
//        int limit = 100;
//
//        WebClient client = WebClient.create("https://www.coinlore.net");
//
//        while (true) {
//            String url = "/api/tickers/?start=" + start + "&limit=" + limit;
//
//            CoinListResponse coinListResponse = client.get()
//                    .uri(url)
//                    .accept(MediaType.APPLICATION_JSON)
//                    .retrieve()
//                    .bodyToMono(CoinListResponse.class)
//                    .block();
//
//            if (coinListResponse == null) {
//                break;
//            }
//
//            List<CoinDto> coinsDtoFromCoinLore = coinListResponse.getData();
//
//            if (coinsDtoFromCoinLore.isEmpty() || coinsDtoFromCoinLore.size() < limit) {
//                break;
//            }
//
//            start += limit;
//
//            saveCoins(coinsDtoFromCoinLore);
//        }
//    }

    public Flux<CoinListResponse> test1() {
        WebClient client = WebClient.create("https://api.coinlore.net");

        return client.get()
                .uri("/api/tickers/?start=100&limit=100")
                .retrieve()
                .bodyToFlux(CoinListResponse.class);
    }

    @Transactional
    public Flux<CryptoEntity> test() {
        WebClient client = WebClient.create("https://api.coinlore.net");

      return client.get()
                .uri("/api/tickers/?start=100&limit=100")
                .retrieve()
                .bodyToFlux(CoinListResponse.class)
                .flatMap(response -> cryptoRepository.saveAll(cryptoMapper.mapListEntityFromListCoinDto(response.getData())))
                .onErrorResume(error -> {
                    throw new RuntimeException("aaa");
                });
    }

    @Transactional
    public Flux<CryptoEntity> saveAll(Flux<CryptoEntity> entities) {
        return cryptoRepository.saveAll(entities);
    }

//    private String sendGetRequest(OkHttpClient client, String url) {
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (response.isSuccessful()) {
//                ResponseBody responseBody = response.body();
//                if (responseBody != null) {
//                    return responseBody.string();
//                }
//            } else {
//                // Обработка ошибки, если требуется
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//    @Transactional
//    public void updateCoins() {
//        int start = 0;
//        int limit = 100;
//
//        OkHttpClient client = new OkHttpClient();
//        Gson gson = new Gson();
//
//        List<CoinDto> result = new ArrayList<>();
//        List<CryptoEntity> entitiesToUpdate = new ArrayList<>();
//        List<CryptoEntity> entitiesToSave = new ArrayList<>();
//
//        while (true) {
//            String url = "https://api.coinlore.net/api/tickers/?start=" + start + "&limit=" + limit;
//
//            String response = sendGetRequest(client, url);
//
//            try {
//                CoinListResponse coinListResponse = gson.fromJson(response, CoinListResponse.class);
//                List<CoinDto> coinsDtoFromCoinLore = coinListResponse.getData();
//
//                result.addAll(coinsDtoFromCoinLore);
//
//                if (coinsDtoFromCoinLore.isEmpty()) {
//                    break;
//                }
//
//                if (coinsDtoFromCoinLore.size() < limit) {
//                    break;
//                }
//
//                start += limit;
//            } catch (JsonSyntaxException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (CoinDto dto : result) {
//            String idFromCoinLore = dto.getId();
//
//            Optional<CryptoEntity> cryptoEntityByIdFromCoinLore = cryptoRepository.findByIdFromCoinLore(idFromCoinLore);
//
//            if (cryptoEntityByIdFromCoinLore.isPresent()) {
//
//                CryptoEntity cryptoEntity = cryptoEntityByIdFromCoinLore.get();
//
//                cryptoEntity.setPercentChange1h(dto.getPercentChange1h());
//                cryptoEntity.setPercentChange7d(dto.getPercentChange7d());
//                cryptoEntity.setPercentChange24h(dto.getPercentChange24h());
//                cryptoEntity.setPriceInUSD(dto.getPriceUsd());
//                cryptoEntity.setRank(dto.getRank());
//
//                entitiesToUpdate.add(cryptoEntity);
//            } else {
//                entitiesToSave.add(cryptoMapper.mapCryptoEntityFromCoinDto(dto));
//            }
//        }
//
//        if (!entitiesToSave.isEmpty()) {
//            cryptoRepository.saveAll(entitiesToSave);
//        }
//
//        if (!entitiesToUpdate.isEmpty()) {
//            cryptoRepository.saveAll(entitiesToUpdate);
//        }
//    }

//    @Transactional
//    public void updateCoins() {
//        int start = 0;
//        int limit = 100;
//
//        OkHttpClient client = new OkHttpClient();
//        Gson gson = new Gson();
//
//        List<CoinDto> result = new ArrayList<>();
//        List<CryptoEntity> entitiesToUpdate = new ArrayList<>();
//        List<CryptoEntity> entitiesToSave = new ArrayList<>();
//
//        while (true) {
//            String url = "https://api.coinlore.net/api/tickers/?start=" + start + "&limit=" + limit;
//
//            String response = sendGetRequest(client, url);
//
//            try {
//                CoinListResponse coinListResponse = gson.fromJson(response, CoinListResponse.class);
//                List<CoinDto> coinsDtoFromCoinLore = coinListResponse.getData();
//
//                result.addAll(coinsDtoFromCoinLore);
//
//                if (coinsDtoFromCoinLore.isEmpty()) {
//                    break;
//                }
//
//                if (coinsDtoFromCoinLore.size() < limit) {
//                    break;
//                }
//
//                start += limit;
//            } catch (JsonSyntaxException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (CoinDto dto : result) {
//            if (checkCryptoEntityByIdFromCoinLore(dto.getId())) {
//
//                CryptoEntity cryptoEntity = cryptoMapper.mapCryptoEntityForUpdateFromCoinDto(dto);
//
//                entitiesToUpdate.add(cryptoEntity);
//            } else {
//                entitiesToSave.add(cryptoMapper.mapCryptoEntityFromCoinDto(dto));
//            }
//        }
//
//        if (!entitiesToSave.isEmpty()) {
//            cryptoRepository.saveAll(entitiesToSave);
//        }
//
//        if (!entitiesToUpdate.isEmpty()) {
//            cryptoRepository.saveAll(entitiesToUpdate);
//        }
//    }
//
//    public boolean checkCryptoEntityByIdFromCoinLore(String idFromCoinLore) {
//        return cryptoRepository.findByIdFromCoinLore(idFromCoinLore).isPresent();
//    }
//
//    //при установке значения "процент"  сделать проверку на налл и >0
//    public boolean checkChangePrice(String oldPrice, String newPrice) {
//        List<UserEntity> usersWithApplicationNotification = userRepository.findAllWithApplicationNotification();
//
//        for (UserEntity user : usersWithApplicationNotification) {
//
//            if (!user.getCryptos().isEmpty()) {
//
//                double oldPriceValue = Double.parseDouble(oldPrice);
//                double newPriceValue = Double.parseDouble(newPrice);
//                double percentValue = Double.parseDouble(user.getPercent());
//
//                double difference = Math.abs((newPriceValue - oldPriceValue) / oldPriceValue * 100);
//
//                if (difference >= percentValue) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
