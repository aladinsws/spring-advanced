-- hôtels
insert into hotel(uuid,nom,nombre_etoiles) values ( '8539d931-fe53-4b57-a128-1afc4ea9b21f', 'Première Classe', 0);
insert into hotel(uuid,nom,nombre_etoiles) values ( 'dcff0dbd-0413-46b6-b37a-cff5b92dc20c', 'Ibis Budget', 2);

-- clients
insert into client(uuid, nom, prenoms) values ('dcf129f1-a2f9-47dc-8265-1d844244b192', 'Odd', 'Ross');
insert into client(uuid, nom, prenoms) values ('f9a18170-9605-4fe6-83c8-d03a53e08bfe', 'Don', 'Duck');
insert into client(uuid, nom, prenoms) values ('91defde0-9ad3-4e4f-886b-f5f06f601a0d', 'Etienne', 'Joly');

-- chambres
insert into chambre(uuid, numero, surface, hotel_uuid) values ('754e6f53-e8f5-4976-9fd2-95e6a427ef1c', 'P1', 10, '8539d931-fe53-4b57-a128-1afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('43793061-f70b-44b9-a855-adc66a2efb9f', 'P2', 20, '8539d931-fe53-4b57-a128-1afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('b13e05d9-d9a9-49a9-80cb-ee03da248102', 'P3', 30, '8539d931-fe53-4b57-a128-1afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('666a2188-8be5-41ce-8800-9f7ba4618521', 'I1', 10, 'dcff0dbd-0413-46b6-b37a-cff5b92dc20c');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('0a0d4672-a273-4e1f-b399-8272ae81296f', 'I2', 20, 'dcff0dbd-0413-46b6-b37a-cff5b92dc20c');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('5eff7155-65f8-4fd0-9209-bb10dfd086c7', 'I3', 30, 'dcff0dbd-0413-46b6-b37a-cff5b92dc20c');


insert into reservation(uuid,date_debut,date_fin) values ('82a23f74-c93d-46a3-946a-c196f6aa147a', '2020-03-01', '2020-04-01');
insert into reservation(uuid,date_debut,date_fin) values ('e2e6d98a-0097-4de6-b71a-eecdabcfb7d9', '2020-03-01', '2020-04-01');


//
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('82a23f74-c93d-46a3-946a-c196f6aa147a', '754e6f53-e8f5-4976-9fd2-95e6a427ef1c');
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('82a23f74-c93d-46a3-946a-c196f6aa147a', '43793061-f70b-44b9-a855-adc66a2efb9f');

insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('e2e6d98a-0097-4de6-b71a-eecdabcfb7d9', '0a0d4672-a273-4e1f-b399-8272ae81296f');
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('e2e6d98a-0097-4de6-b71a-eecdabcfb7d9', '5eff7155-65f8-4fd0-9209-bb10dfd086c7');







