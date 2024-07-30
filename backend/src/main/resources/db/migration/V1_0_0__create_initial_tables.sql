-- create table if not exists regions: region_id integer, region_name varchar256
CREATE TABLE IF NOT EXISTS regions (
    region_id SERIAL PRIMARY KEY,
    region_name VARCHAR(256) NOT NULL
);

-- create table if not exists countries: country_id integer, country_name varchar256, country_code varchar10, fk_region_id integer
CREATE TABLE IF NOT EXISTS countries (
    country_id SERIAL PRIMARY KEY,
    country_name VARCHAR(256) NOT NULL,
    country_code VARCHAR(10) NOT NULL,
    fk_region_id INTEGER REFERENCES regions(region_id)
);

-- Create enum type for station_status
DO $$ BEGIN
    CREATE TYPE station_status_enum AS ENUM ('active', 'limited', 'closed');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

-- create table if not exists stations: station_id, station original name_ varchar256, station longitude float, station_latitude float, station_address varchar256, fk_country_id integer, station_status enum(active, limited, closed)
CREATE TABLE IF NOT EXISTS stations (
    station_id SERIAL PRIMARY KEY,
    station_original_name VARCHAR(256) NOT NULL,
    station_longitude FLOAT NOT NULL,
    station_latitude FLOAT NOT NULL,
    station_address VARCHAR(256) NOT NULL,
    fk_country_id INTEGER REFERENCES countries(country_id),
    station_status station_status_enum NOT NULL
);


-- create table if not exists external_media_links: id integer, link(256), media links type varchar(128), fk_station_id integer
CREATE TABLE IF NOT EXISTS external_media_links (
    id SERIAL PRIMARY KEY,
    link VARCHAR(256) NOT NULL,
    media_links_type VARCHAR(128) NOT NULL,
    fk_station_id INTEGER REFERENCES stations(station_id)
);

-- create table if not exists external_resources: id integer, media link varchar(256), media type varchar(128), fk_station_id integer
CREATE TABLE IF NOT EXISTS external_resources (
    id SERIAL PRIMARY KEY,
    link VARCHAR(256) NOT NULL,
    media_type VARCHAR(128) NOT NULL,
    fk_station_id INTEGER REFERENCES stations(station_id)
);

-- Create enum type for seal_type
DO $$ BEGIN
    CREATE TYPE seal_type_enum AS ENUM ('eared', 'earless');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

-- create table if not exists seals: seal_id, seal_type enum(eared, earless)
CREATE TABLE IF NOT EXISTS seals (
    seal_id SERIAL PRIMARY KEY,
    seal_type seal_type_enum NOT NULL
);


-- create table if not exists seals_stations: seals_stations_id integer, fk_seal_id int, fk_station_id integer
CREATE TABLE IF NOT EXISTS seals_stations (
    seals_stations_id SERIAL PRIMARY KEY,
    fk_seal_id INTEGER REFERENCES seals(seal_id),
    fk_station_id INTEGER REFERENCES stations(station_id)
);

-- create table if not exists supported_languages: supported_languages_id integer, language_name varchar128
CREATE TABLE IF NOT EXISTS supported_languages (
    supported_languages_id SERIAL PRIMARY KEY,
    language_name VARCHAR(128) NOT NULL
);

-- create table if not exists seals_language_name: id integer, name varchar128, fk_seal_id int, fk_supported_language_id integer
CREATE TABLE IF NOT EXISTS seals_language_name (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    fk_seal_id INTEGER REFERENCES seals(seal_id),
    fk_supported_language_id INTEGER REFERENCES supported_languages(supported_languages_id)
);

-- create table if not exists roles: role_id integer, role_name varchar128
CREATE TABLE IF NOT EXISTS roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(128) NOT NULL
);

-- create table if not exists station_news: id integer, news_external_link varchar256, news summary text, updated at date, created at, fk_station_id integer
CREATE TABLE IF NOT EXISTS station_news (
    id SERIAL PRIMARY KEY,
    news_external_link VARCHAR(256),
    news_summary TEXT,
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    fk_station_id INTEGER REFERENCES stations(station_id)
);