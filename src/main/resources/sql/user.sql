-- Table: User
CREATE TABLE user (
  id        INT          NOT NULL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  age       INT          NOT NULL
)
  ENGINE = InnoDB;

-- Data insert into table: user
INSERT INTO user VALUE (1, 'Sergii', 'Gagauz', 55);
INSERT INTO user VALUE (2, 'Vitalii', 'Volkov', 65);
