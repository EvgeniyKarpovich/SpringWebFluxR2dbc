CREATE TABLE cryptos (
    id         SERIAL PRIMARY KEY,
    idFromCoinLore   VARCHAR(256)   NOT NULL,
    name   VARCHAR(256) NOT NULL,
    symbol       VARCHAR(256)   NOT NULL,
    rank INTEGER   NOT NULL,
    priceInUSD  VARCHAR(256)   NOT NULL,
    percentChange24h  VARCHAR(256)   NOT NULL,
    percentChange1h  VARCHAR(256)   NOT NULL,
    percentChange7d  VARCHAR(256)   NOT NULL
);