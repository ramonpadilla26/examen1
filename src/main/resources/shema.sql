DROP TABLE IF EXISTS TBL_ANIMALES,TBL_USER;
CREATE TABLE TBL_ANIMALES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoanimal VARCHAR(250) NOT NULL,
    color   VARCHAR(250) NOT NULL,
    raza    VARCHAR(250) NOT NULL,
    tipopelo VARCHAR(250) NOT NULL,
    fechanac VARCHAR(250) NOT NULL,
    vacunas BOOLEAN,
    estadoadopcion BOOLEAN,
    nombredueño VARCHAR(250) NOT NULL,

    img BINARY,
    str VARCHAR(250) NOT NULL
);


CREATE TABLE TBL_USER (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          user_name VARCHAR(250) NOT NULL,
                          password VARCHAR(250) NOT NULL,
                          active BIT DEFAULT NULL,
                          roles VARCHAR (250) DEFAULT NULL
);