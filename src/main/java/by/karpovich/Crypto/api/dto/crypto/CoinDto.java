package by.karpovich.Crypto.api.dto.crypto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CoinDto {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameid")
    @Expose
    private String nameid;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("price_usd")
    @Expose
    private String priceUsd;
    @SerializedName("percent_change_24h")
    @Expose
    private String percentChange24h;
    @SerializedName("percent_change_1h")
    @Expose
    private String percentChange1h;
    @SerializedName("percent_change_7d")
    @Expose
    private String percentChange7d;
    @SerializedName("market_cap_usd")
    @Expose
    private String marketCapUsd;
    @SerializedName("volume24")
    @Expose
    private String volume24;
    @SerializedName("volume24_native")
    @Expose
    private String volume24Native;
    @SerializedName("csupply")
    @Expose
    private String csupply;
    @SerializedName("price_btc")
    @Expose
    private String priceBtc;
    @SerializedName("tsupply")
    @Expose
    private String tsupply;
    @SerializedName("msupply")
    @Expose
    private String msupply;

    public CoinDto() {
    }

    public CoinDto(String id, String symbol, String name, String nameid, Integer rank, String priceUsd, String percentChange24h, String percentChange1h, String percentChange7d, String marketCapUsd, String volume24, String volume24Native, String csupply, String priceBtc, String tsupply, String msupply) {
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
