USE usuariosregistro;

CREATE TABLE usuario(
	idusuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR (45) NOT NULL,
    nickname VARCHAR (45),
    pass VARCHAR (45) NOT NULL,
    PRIMARY KEY (idusuario),
    UNIQUE INDEX nickname (nickname),
    UNIQUE INDEX idusuario (idusuario)
)AUTO_INCREMENT = 1;