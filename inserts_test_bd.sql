INSERT INTO conta VALUES ('70144755832','Lara','Lara@email.com','Brasileiro',0,'s','-');
INSERT INTO conta VALUES ('70244855933','Sarah','Sarah@email.com','Brasileiro',1,'s','-');
INSERT INTO conta VALUES ('70344956034','Nicole','Nicole@email.com','Brasileiro',0,'s','-');
INSERT INTO conta VALUES ('70445056135','Isabelly','Isabelly@email.com','Brasileiro',0,'s','-');
INSERT INTO conta VALUES ('70545156236','Esther','Esther@email.com','Brasileiro',0,'s','-');

INSERT INTO viewer VALUES ('70144755832','70144755832');
INSERT INTO viewer VALUES ('70244855933','70244855933');
INSERT INTO viewer VALUES ('70344956034','70344956034');
INSERT INTO viewer VALUES ('70445056135','70445056135');


INSERT INTO streamer VALUES ('70545156236','70545156236',3);


INSERT INTO seguir VALUES ('70144755832','70545156236');
INSERT INTO seguir VALUES ('70244855933','70545156236');
INSERT INTO seguir VALUES ('70344956034','70545156236');
INSERT INTO seguir VALUES ('70445056135','70545156236');


INSERT INTO cartao VALUES (4812739085729160,128,'2023-05-25','70144755832');
INSERT INTO cartao VALUES (6398051247832400,765,'2023-09-23','70244855933');
INSERT INTO cartao VALUES (8201465973825140,493,'2023-11-27','70344956034');
INSERT INTO cartao VALUES (5672904318650920,901,'2023-08-24','70445056135');
INSERT INTO cartao VALUES (7246301589643080,624,'2023-03-28','70545156236');


INSERT INTO rede_social VALUES ('70144755832','www.instagram.com/LaraGamingWorld','@LaraGamingJourney');
INSERT INTO rede_social VALUES ('70244855933','www.facebook.com/SarahliveStreams','@SarahGameRealm');
INSERT INTO rede_social VALUES ('70344956034','www.facebook.com/NicoleliveGaming','@NicoleGamerGal');
INSERT INTO rede_social VALUES ('70445056135','www.instagram.com/IsabellylivePlays','@IsabellyGaming');
INSERT INTO rede_social VALUES ('70545156236','www.facebook.com/EstherGamingRealm','@EstherPlaysOn');


INSERT INTO conta_bancaria VALUES ('70144755832',1234,12345678,'Bradesco');

INSERT INTO patrocinador VALUES (67890123000156,'PetPalace Pet Care');
INSERT INTO patrocinador VALUES (23456789000189,'UrbanSculpt Architecture');


INSERT INTO patrocinador_streamer VALUES (67890123000156,'70545156236', 4000.00);
INSERT INTO patrocinador_streamer VALUES (23456789000189,'70545156236', 2000.00);


INSERT INTO live VALUES ('www.twitch.tv/EstherGamingRealm','a',2473,'2023-01-15',278,'70545156236');

INSERT INTO conta_live VALUES ('70545156236','www.twitch.tv/EstherGamingRealm');

INSERT INTO categoria VALUES ('www.twitch.tv/EstherGamingRealm','Esther: Vem pro lolzinho');

INSERT INTO presente VALUES ('www.twitch.tv/EstherGamingRealm','megaChat',5.5);
INSERT INTO presente VALUES ('www.twitch.tv/EstherGamingRealm','Emoji',2.5);

INSERT INTO comentario VALUES ('www.twitch.tv/EstherGamingRealm','Que jogada incrível! Você é um mestre nesse jogo!','70144755832');
INSERT INTO comentario VALUES ('www.twitch.tv/EstherGamingRealm','Os gráficos são de tirar o fôlego. Que espetáculo!','70244855933');
INSERT INTO comentario VALUES ('www.twitch.tv/EstherGamingRealm','Estou torcendo por você até o último nível!','70344956034');
INSERT INTO comentario VALUES ('www.twitch.tv/EstherGamingRealm','Adoro a energia e empolgação da sua live!','70445056135');
