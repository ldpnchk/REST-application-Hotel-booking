INSERT INTO room_category (id, name) VALUES (1, 'Standart');
INSERT INTO room_category (id, name) VALUES (2, 'Junior Suite');
INSERT INTO room_category (id, name) VALUES (3, 'Suite');

INSERT INTO room (id, number, price, id_room_category) VALUES (1, '11', 800.00, 1);
INSERT INTO room (id, number, price, id_room_category) VALUES (2, '12', 800.00, 1);
INSERT INTO room (id, number, price, id_room_category) VALUES (3, '13', 1000.00, 1);
INSERT INTO room (id, number, price, id_room_category) VALUES (4, '14', 1000.00, 1);
INSERT INTO room (id, number, price, id_room_category) VALUES (5, '15', 1050.00, 1);
INSERT INTO room (id, number, price, id_room_category) VALUES (6, '22', 1800.00, 2);
INSERT INTO room (id, number, price, id_room_category) VALUES (7, '23', 1800.00, 2);
INSERT INTO room (id, number, price, id_room_category) VALUES (8, '31', 2800.00, 3);
INSERT INTO room (id, number, price, id_room_category) VALUES (9, '41', 3500.00, 3);

INSERT INTO hotel_service (id, name, price) VALUES (1, 'Parking lot', 200.75);
INSERT INTO hotel_service (id, name, price) VALUES (2, 'Breakfast', 150.00);
INSERT INTO hotel_service (id, name, price) VALUES (3, 'Cleaning', 250.00);

INSERT INTO user (id, first_name, last_name) VALUES (1, 'Ivan', 'Ivanov');
INSERT INTO user (id, first_name, last_name) VALUES (2, 'Petro', 'Petrov');
INSERT INTO user (id, first_name, last_name) VALUES (3, 'Pavlo', 'Pavlov');

INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (1, '2019-04-01', '2019-04-10', 1, 1);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (2, '2019-04-11', '2019-04-15', 1, 4);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (3, '2019-04-10', '2019-04-11', 2, 6);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (4, '2019-04-11', '2019-04-12', 2, 7);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (5, '2019-04-13', '2019-04-14', 2, 8);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (6, '2019-04-14', '2019-04-15', 2, 9);
INSERT INTO booking (id, start_date, end_date, id_user, id_room) VALUES (7, '2019-04-05', '2019-04-12', 3, 2);

INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (3, 2);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (4, 2);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (5, 2);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (6, 2);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (4, 3);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (6, 3);
INSERT INTO booking_hotel_service (id_booking, id_hotel_service) VALUES (7, 1);