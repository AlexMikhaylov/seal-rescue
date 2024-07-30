-- Insert data into regions table
COPY regions (region_id, region_name)
FROM './../data/regions.csv'
DELIMITER ','
CSV HEADER;