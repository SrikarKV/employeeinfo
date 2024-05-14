CREATE TABLE user
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);