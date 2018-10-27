CREATE TABLE alumnos (
                       ID INT NOT NULL IDENTITY    PRIMARY KEY,
                       NOMBRE varchar(250)  DEFAULT NULL,
                       FECHA_NACIMIENTO date DEFAULT NULL,
                       MAYOR_EDAD BOOLEAN DEFAULT NULL,
                       PRIMARY KEY (ID)
                     );
					 
					 CREATE TABLE asignaturas (
                      ID INT NOT NULL IDENTITY    PRIMARY KEY,
                      NOMBRE varchar(250) NOT NULL,
                      CURSO varchar(250) NOT NULL,
                      CICLO varchar(250) NOT NULL,
                      PRIMARY KEY (ID)
                    );
					
					
CREATE TABLE notas (
                      ID_ALUMNOS INT NOT NULL,
                      ID_ASIGNATURAS INT NOT NULL,
                      notas INT DEFAULT 0 NOT NULL ,
                      PRIMARY KEY (ID_ALUMNOS,ID_ASIGNATURAS),
                      CONSTRAINT NOTAS_ALUMNOS FOREIGN KEY (ID_ALUMNOS) REFERENCES alumnos (ID),
                      CONSTRAINT NOTAS_ASIGNATURAS FOREIGN KEY (ID_ASIGNATURAS) REFERENCES asignaturas (ID)
                    )					