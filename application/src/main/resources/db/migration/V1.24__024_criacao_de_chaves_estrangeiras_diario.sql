--ALTER TABLE media_movel_simples_diario DROP CONSTRAINT fk_media_movel_simples_diario_candlestick;
--ALTER TABLE media_movel_exponencial_diario DROP CONSTRAINT fk_media_movel_exponencial_diario_candlestick;
--ALTER TABLE macd_diario DROP CONSTRAINT fk_macd_diario_candlestick;
--ALTER TABLE sinal_macd_diario DROP CONSTRAINT fk_sinal_macd_diario_candlestick;
--ALTER TABLE histograma_diario DROP CONSTRAINT fk_histograma_diario_candlestick;
--ALTER TABLE histograma_diario DROP CONSTRAINT fk_histograma_diario_candlestick;
--ALTER TABLE recomendacao_diario DROP CONSTRAINT fk_recomendacao_diario_candlestick;

ALTER TABLE media_movel_simples_diario
ADD CONSTRAINT fk_media_movel_simples_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);

ALTER TABLE media_movel_exponencial_diario
ADD CONSTRAINT fk_media_movel_exponencial_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);

ALTER TABLE macd_diario
ADD CONSTRAINT fk_macd_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);

ALTER TABLE sinal_macd_diario
ADD CONSTRAINT fk_sinal_macd_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);

ALTER TABLE histograma_diario
ADD CONSTRAINT fk_histograma_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);

ALTER TABLE recomendacao_diario
ADD CONSTRAINT fk_recomendacao_diario_candlestick
FOREIGN KEY (codneg, dtpreg) REFERENCES candlestick_diario (codneg, dtpreg);
