package by.karpovich.Crypto.api.dto.crypto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinCoin {

        @JsonProperty("id")
        private String id;
        @JsonProperty("symbol")
        private String symbol;
        @JsonProperty("name")
        private String name;
        @JsonProperty("nameid")
        private String nameid;
        @JsonProperty("rank")
        private Integer rank;
        @JsonProperty("price_usd")
        private String priceUsd;
        @JsonProperty("percent_change_24h")
        private String percentChange24h;
        @JsonProperty("percent_change_1h")
        private String percentChange1h;
        @JsonProperty("percent_change_7d")
        private String percentChange7d;
        @JsonProperty("price_btc")
        private String priceBtc;
        @JsonProperty("market_cap_usd")
        private String marketCapUsd;
        @JsonProperty("volume24")
        private Double volume24;
        @JsonProperty("volume24a")
        private Double volume24a;
        @JsonProperty("csupply")
        private String csupply;
        @JsonProperty("tsupply")
        private String tsupply;
        @JsonProperty("msupply")
        private String msupply;
}
