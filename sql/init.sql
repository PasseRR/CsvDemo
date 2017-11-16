DROP TABLE IF EXISTS time_series_data;
CREATE TABLE time_series_data (
  item_id      VARCHAR(32),
  trading_date DATE,
  stock_code   VARCHAR(64),
  item_value1  DOUBLE,
  item_value2  DOUBLE,
  item_value3  DOUBLE,
  PRIMARY KEY (item_id, trading_date, stock_code)
)