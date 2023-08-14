CREATE TABLE users (
    id         SERIAL PRIMARY KEY,
    idFromCoinLore   VARCHAR(256)   NOT NULL UNIQUE,
    name   VARCHAR(256) NOT NULL,
    symbol       VARCHAR(256)   NOT NULL,
    rank INTEGER(256)   NOT NULL,
    priceInUSD  VARCHAR(256)   NOT NULL,
    percentChange24h  VARCHAR(256)   NOT NULL,
    percentChange1h  VARCHAR(256)   NOT NULL,
    percentChange7d  VARCHAR(256)   NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);