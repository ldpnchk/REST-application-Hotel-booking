package com.pinchuk.resthotelbooking.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pinchuk.resthotelbooking.domain.Room;
import com.pinchuk.resthotelbooking.domain.RoomCategory;

public interface RoomRepo extends JpaRepository<Room, Long> {
	
	public static final String GET_FREE_ROOMS_BY_DATES_SQL = "SELECT * FROM room WHERE NOT EXISTS "
			+ "(SELECT * FROM booking WHERE (((?1 >= booking.start_date AND ?1 < booking.end_date) "
			+ "OR (?2 > booking.start_date AND ?2 <= booking.end_date)) "
			+ "OR ((booking.start_date >= ?1 AND booking.start_date < ?2) "
			+ "OR (booking.end_date > ?1 AND booking.end_date <= ?2))) "
			+ "AND (booking.id_room = room.id))";
	
	@Query(value = GET_FREE_ROOMS_BY_DATES_SQL, nativeQuery = true)
	List<Room> findFreeRoomsByDates(LocalDate startDate, LocalDate endDate);
	
	List<Room> findByRoomCategory(RoomCategory roomCategory);

}
