
INSERT INTO USER_PROFILE(type) VALUES ('USER');

INSERT INTO USER_PROFILE(type) VALUES ('ADMIN');

INSERT INTO USER_PROFILE(type) VALUES ('DBA');




/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(DTYPE, sso_id, password, email) VALUES ('Client','sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'samy@xyz.com');

/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id) SELECT client.id, profile.id FROM app_user client, user_profile profile where client.sso_id='sam' and profile.type='ADMIN';

INSERT INTO model(id, enginePowerHP, modelName, openRoof, type, yearOfRelease) VALUES (1, 500,'Tesla Model S',false, 'Sedan',1996);
INSERT INTO model(id, enginePowerHP, modelName, openRoof, type, yearOfRelease) VALUES (2, 1500000,'Milenium Falcon',false, 'Starship',30015);
INSERT INTO model(id, enginePowerHP, modelName, openRoof, type, yearOfRelease) VALUES (3, 10,'Lada 2104',false, 'Sedan',1996);
INSERT INTO model(id, enginePowerHP, modelName, openRoof, type, yearOfRelease) VALUES (4, 10,'BMW7',false, 'Sedan',2015);

INSERT INTO car(id, color, imageLink, milage, recomendedPrice, warrantyTerm, carModel_id) VALUES (1, 'Blue', 'https://image.ibb.co/bTu70v/car.jpg', 3000, 55000, 200, 1);
INSERT INTO car(id, color, imageLink, milage, recomendedPrice, warrantyTerm, carModel_id) VALUES (2, 'White' , 'https://image.ibb.co/fd6RtF/millennium_falcon_space.jpg', 5000, 65000, 200, 2);
INSERT INTO car(id, color, imageLink, milage, recomendedPrice, warrantyTerm, carModel_id) VALUES (3, 'Silver', 'https://image.ibb.co/hrCGtF/car1.jpg', 4000, 45000, 200, 3);
INSERT INTO car(id, color, imageLink, milage, recomendedPrice, warrantyTerm, carModel_id) VALUES (4, 'White', 'https://image.ibb.co/nmxS0v/car2.jpg', 5000, 65000, 200, 4);


