### REST application Hotel booking

Installation guide
1. Software requirements: JDK 1.8+, Maven.
2. Clone project.
3. Execute command in the project root directory:
	mvn spring-boot:run
	
Data insertion script is located at: \src\main\resources\data.sql
	
Endpoints:
1. View list of available rooms for specified dates.
	Method = GET
	URL = /room/getAvailableRooms?startDate={start_date}&endDate={end_date}
		Notice: {start_date} should be before {end_date}
	Request example:
		/room/getAvailableRooms?startDate=2020-04-12&endDate=2020-09-13
	Response example:
		[
			{
				"id": 1,
				"number": "11",
				"price": 800,
				"roomCategory": {
					"id": 1,
					"name": "Standart"
				}
			},
			{
				"id": 2,
				"number": "12",
				"price": 800,
				"roomCategory": {
					"id": 1,
					"name": "Standart"
				}
			}
		]
		
2. View rooms filtered by category.
	Method = GET
	URL = /room/getRoomsByCategory?categoryId={category_id}
	Request example:
		/room/getRoomsByCategory?categoryId=2
	Response example:
		[
			{
				"id": 6,
				"number": "22",
				"price": 1800,
				"roomCategory": {
					"id": 2,
					"name": "Junior Suite"
				}
			},
			{
				"id": 7,
				"number": "23",
				"price": 1800,
				"roomCategory": {
					"id": 2,
					"name": "Junior Suite"
				}
			}
		]
		
3. Create user.
	Method = POST
	URL = /user/create
	Request body example:
		{
			"firstName": "Olena",
			"lastName": "Tkachuk"
		}
	Response example:
		{
			"id": 4,
			"firstName": "Olena",
			"lastName": "Tkachuk"
		}

4. User can book the room for specified days.
	Method = POST
	URL = /booking/create
		Notice: "startDate" should be before "endDate"
				"startDate" shouldn't be for a passed date
	Request body example:
		{
			"startDate": "2019-04-25",
			"endDate":	"2019-04-29",
			"roomId": 1,
			"userId": 1,
			"hotelServiceIds": [1, 2, 3]
		}
	Response example:
		{
			"id": 8,
			"startDate": "2022-12-12",
			"endDate": "2022-12-21",
			"room": {
				"id": 1,
				"number": "11",
				"price": 800,
				"roomCategory": {
					"id": 1,
					"name": "Standart"
				}
			},
			"user": {
				"id": 1,
				"firstName": "Ivan",
				"lastName": "Ivanov"
			},
			"hotelServices": [
				{
					"id": 1,
					"name": "Parking lot",
					"price": 200.75
				},
				{
					"id": 2,
					"name": "Breakfast",
					"price": 150
				},
				{
					"id": 3,
					"name": "Cleaning",
					"price": 250
				}
			]
		}
		
5. User can view his booking.
	Method = GET
	URL = /booking/getByUser?userId={user_id}
	Request example:
		/booking/getByUser?userId=3
	Response example:
		[
			{
				"id": 7,
				"startDate": "2019-04-05",
				"endDate": "2019-04-12",
				"room": {
					"id": 2,
					"number": "12",
					"price": 800,
					"roomCategory": {
						"id": 1,
						"name": "Standart"
					}
				},
				"user": {
					"id": 3,
					"firstName": "Pavlo",
					"lastName": "Pavlov"
				},
				"hotelServices": [
					{
						"id": 1,
						"name": "Parking lot",
						"price": 200.75
					}
				]
			}
		]
	
6. User can get the total price of the booking (room for dates period + cost of additional options).
	Method = GET
	URL = /booking/getTotalPrice?bookingId={booking_id}
	Request example:
		/booking/getTotalPrice?bookingId=3
	Response example:
		1950
		
7. View all bookings for the hotel.
	Method = GET
	URL = /booking/getAll
	Request example:
		/booking/getAll
	Response example:
		[
			{
				"id": 1,
				"startDate": "2019-04-01",
				"endDate": "2019-04-10",
				"room": {
					"id": 1,
					"number": "11",
					"price": 800,
					"roomCategory": {
						"id": 1,
						"name": "Standart"
					}
				},
				"user": {
					"id": 1,
					"firstName": "Ivan",
					"lastName": "Ivanov"
				},
				"hotelServices": []
			},
			{
				"id": 2,
				"startDate": "2019-04-11",
				"endDate": "2019-04-15",
				"room": {
					"id": 4,
					"number": "14",
					"price": 1000,
					"roomCategory": {
						"id": 1,
						"name": "Standart"
					}
				},
				"user": {
					"id": 1,
					"firstName": "Ivan",
					"lastName": "Ivanov"
				},
				"hotelServices": []
			},
			{
				"id": 3,
				"startDate": "2019-04-10",
				"endDate": "2019-04-11",
				"room": {
					"id": 6,
					"number": "22",
					"price": 1800,
					"roomCategory": {
						"id": 2,
						"name": "Junior Suite"
					}
				},
				"user": {
					"id": 2,
					"firstName": "Petro",
					"lastName": "Petrov"
				},
				"hotelServices": [
					{
						"id": 2,
						"name": "Breakfast",
						"price": 150
					}
				]
			}
		]