SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS musicuser;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE genre (
    genre_id BIGINT NOT NULL AUTO_INCREMENT,
    nimi VARCHAR(50) NOT NULL,
    PRIMARY KEY (genre_id)
);

CREATE TABLE artist (
    artist_id BIGINT NOT NULL AUTO_INCREMENT,
    etunimi VARCHAR(50) NOT NULL,
    sukunimi VARCHAR(50) NOT NULL,
    ika INT NOT NULL,
    kotimaa VARCHAR(30) NOT NULL,
    PRIMARY KEY(artist_id)
);

CREATE TABLE album (
    album_id BIGINT NOT NULL AUTO_INCREMENT,
    nimi VARCHAR(100) NOT NULL,
    vuosi INT,
    genre_id BIGINT,
    artist_id BIGINT,
    PRIMARY KEY (album_id),
    FOREIGN KEY (genre_id) REFERENCES genre(genre_id),
    FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE musicuser (
    user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password_hash VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    role VARCHAR(100) NOT NULL
);

INSERT INTO artist(etunimi, sukunimi, ika, kotimaa)
VALUES("Ville","Valo",50,"Suomi"),
("Michael","Monroe",62,"Suomi"),
("Anna","Puu",42,"Suomi"),
("Bruce","Springsteen",78,"USA");

INSERT INTO genre(nimi)
VALUES("ROCK"),("METAL"),("METALCORE"),("HARDROCK"),("HEAVY"),("POP"),("COUNTRY"),("CLASSIC");

INSERT INTO album (nimi, vuosi, genre_id, artist_id)
VALUES 
("Hail to the king",2013,1,1),
("Astronaut in the Ocean",2021,2,2),
("Trauma",2019,3,3),
("Watch the world burn",2023,4,4);

INSERT INTO musicuser(username, password_hash, email, role)
VALUES 
("user", "$2a$10$pvNerE7u.fgbad/NyP6Q5ex601Il.2b17P0ZGi0pEdDl9PruRiRGu","testi1@gmail.com","USER"),
("admin", "$2a$10$G1FopiYLR9Ek.tgVvJauceUBjNl3R/atQE6dmOmflSdV709SD.4nW","testi2@gmail.com","ADMIN");

SELECT * FROM artist;
SELECT * FROM genre;
SELECT * FROM musicuser;
SELECT * FROM album;
