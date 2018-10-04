CREATE DATABASE agenda_mvc;

USE agenda_mvc;

CREATE TABLE contactos( 
    id_contacto integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    email varchar(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `contactos` (`id_contacto`, `nombre`, `email`) VALUES
(1, 'Diana Octaviano', 'diana.valeria201@gmail.com'),
(2, 'Alexis Hermandez', 'Alexis@email.com'),
(3, 'Estefania Garcia', 'fannygarcia@outlook.com'),
(4, 'Luisa', 'luisa@outlook.com');



SELECT * FROM contactos;

CREATE USER 'user_mvc'@'localhost' IDENTIFIED BY 'pass_mvc.2018';
GRANT ALL PRIVILEGES ON agenda_mvc.* TO 'user_mvc'@'localhost';
FLUSH PRIVILEGES;
