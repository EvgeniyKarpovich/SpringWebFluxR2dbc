package by.karpovich.Crypto.api.dto.crypto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinResult {

    public String id;
    public String symbol;
    public String name;
    @SerializedName("nameid")
    @Expose
    public String nameid;
    @SerializedName("rank")
    @Expose
    public Integer rank;
    @SerializedName("price_usd")
    @Expose
    public String priceUsd;
    @SerializedName("percent_change_24h")
    @Expose
    public String percentChange24h;
    @SerializedName("percent_change_1h")
    @Expose
    public String percentChange1h;
    @SerializedName("percent_change_7d")
    @Expose
    public String percentChange7d;
    @SerializedName("market_cap_usd")
    @Expose
    public String marketCapUsd;
    @SerializedName("volume24")
    @Expose
    public String volume24;
    @SerializedName("volume24_native")
    @Expose
    public String volume24Native;
    @SerializedName("csupply")
    @Expose
    public String csupply;
    @SerializedName("price_btc")
    @Expose
    public String priceBtc;
    @SerializedName("tsupply")
    @Expose
    public String tsupply;
    @SerializedName("msupply")
    @Expose
    public String msupply;

    public CoinResult() {
    }

    public CoinResult(String id, String symbol, String name, String nameid, Integer rank, String priceUsd, String percentChange24h, String percentChange1h, String percentChange7d, String marketCapUsd, String volume24, String volume24Native, String csupply, String priceBtc, String tsupply, String msupply) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.percentChange24h = percentChange24h;
        this.percentChange1h = percentChange1h;
        this.percentChange7d = percentChange7d;
        this.marketCapUsd = marketCapUsd;
        this.volume24 = volume24;
        this.volume24Native = volume24Native;
        this.csupply = csupply;
        this.priceBtc = priceBtc;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }
}
