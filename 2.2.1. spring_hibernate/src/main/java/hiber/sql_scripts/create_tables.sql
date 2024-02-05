/*CREATE TABLE spring_hiber.car
(
    id     int NOT NULL AUTO_INCREMENT,
    series int,
    model  varchar(45),
    PRIMARY KEY (id)
);*/

CREATE TABLE spring_hiber.users
(
    id        int NOT NULL AUTO_INCREMENT,
    name      varchar(45),
    last_name varchar(45),
    email     varchar(45),
    car_id    int,
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES spring_hiber.car (id)
);