CREATE TABLE cryptos (
    id         SERIAL PRIMARY KEY,
    id_from_coin_lore   VARCHAR(256) ,
    name   VARCHAR(256),
    symbol   VARCHAR(256),
    rank INTEGER,
    price_in_usd  VARCHAR(256),
    percent_change_24h  VARCHAR(256) ,
    percent_change_1h  VARCHAR(256),
    percent_change_7d  VARCHAR(256)
);