--ALTER TABLE media_movel_simples_semanal DROP CONSTRAINT fk_media_movel_simples_semanal_candlestick;
--ALTER TABLE media_movel_exponencial_semanal DROP CONSTRAINT fk_media_movel_exponencial_semanal_candlestick;
--ALTER TABLE macd_semanal DROP CONSTRAINT fk_macd_semanal_candlestick;
--ALTER TABLE sinal_macd_semanal DROP CONSTRAINT fk_sinal_macd_semanal_candlestick;
--ALTER TABLE histograma_semanal DROP CONSTRAINT fk_histograma_semanal_candlestick;
--ALTER TABLE histograma_semanal DROP CONSTRAINT fk_histograma_semanal_candlestick;
--ALTER TABLE recomendacao_semanal DROP CONSTRAINT fk_recomendacao_semanal_candlestick;

ALTER TABLE media_movel_simples_semanal
ADD CONSTRAINT fk_media_movel_simples_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);

ALTER TABLE media_movel_exponencial_semanal
ADD CONSTRAINT fk_media_movel_exponencial_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);

ALTER TABLE macd_semanal
ADD CONSTRAINT fk_macd_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);

ALTER TABLE sinal_macd_semanal
ADD CONSTRAINT fk_sinal_macd_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);

ALTER TABLE histograma_semanal
ADD CONSTRAINT fk_histograma_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);

ALTER TABLE recomendacao_semanal
ADD CONSTRAINT fk_recomendacao_semanal_candlestick
FOREIGN KEY (codneg, dtpregini) REFERENCES candlestick_semanal (codneg, dtpregini);
