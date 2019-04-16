package com.pinchuk.resthotelbooking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.pinchuk.resthotelbooking.controller.BookingController;
import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.HotelService;
import com.pinchuk.resthotelbooking.domain.Room;
import com.pinchuk.resthotelbooking.domain.RoomCategory;
import com.pinchuk.resthotelbooking.domain.User;
import com.pinchuk.resthotelbooking.service.BookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookingService bookingServiceMock;
	
	@Test
	public void getTotalPrice() throws Exception{
		LocalDate localDate1 = LocalDate.of(2019, 3, 15);
		LocalDate localDate2 = LocalDate.of(2019, 3, 16);
		Room room1 = new Room(1l, "101", new BigDecimal(100), new RoomCategory(), new ArrayList<Booking>());
		User user1 = new User(1l, "Artem", "Artemov", new ArrayList<Booking>());
		Booking booking1 = new Booking(1l, localDate1, localDate2, room1, user1, new ArrayList<HotelService>());
		BigDecimal price = new BigDecimal(100);
		
        when(bookingServiceMock.getTotalPrice(1l)).thenReturn(price);
        
        mockMvc.perform(get("/booking/getTotalPrice?bookingId=" + booking1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", is(100)));
        
        verify(bookingServiceMock, times(1)).getTotalPrice(booking1.getId());
        verifyNoMoreInteractions(bookingServiceMock);
	}
	
	@Test
	public void getByUser() throws Exception{
		LocalDate localDate1 = LocalDate.of(2019, 3, 15);
		LocalDate localDate2 = LocalDate.of(2019, 3, 16);
		Room room1 = new Room(1l, "101", new BigDecimal(100), new RoomCategory(), new ArrayList<Booking>());
		User user1 = new User(1l, "Artem", "Artemov", new ArrayList<Booking>());
		Booking booking1 = new Booking(1l, localDate1, localDate2, room1, user1, new ArrayList<HotelService>());
		
		user1.getBookings().add(booking1);
        when(bookingServiceMock.getByUser(1l)).thenReturn(user1.getBookings());
        
        mockMvc.perform(get("/booking/getByUser?userId=" + user1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2019-03-15")))
                .andExpect(jsonPath("$[0].endDate", is("2019-03-16")));
        
        verify(bookingServiceMock, times(1)).getByUser(user1.getId());
        verifyNoMoreInteractions(bookingServiceMock);
	}
	
	@Test
	public void getAll() throws Exception{
		LocalDate localDate1 = LocalDate.of(2019, 3, 15);
		LocalDate localDate2 = LocalDate.of(2019, 3, 16);
		LocalDate localDate3 = LocalDate.of(2019, 3, 17);
		LocalDate localDate4 = LocalDate.of(2019, 3, 18);
		
		Booking booking1 = new Booking(1l, localDate1, localDate2, new Room(), new User(), new ArrayList<HotelService>());
		Booking booking2 = new Booking(2l, localDate3, localDate4, new Room(), new User(), new ArrayList<HotelService>());
		
        when(bookingServiceMock.getAll()).thenReturn(Arrays.asList(booking1, booking2));
        
        mockMvc.perform(get("/booking/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2019-03-15")))
                .andExpect(jsonPath("$[0].endDate", is("2019-03-16")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].startDate", is("2019-03-17")))
                .andExpect(jsonPath("$[1].endDate", is("2019-03-18")));
 
        verify(bookingServiceMock, times(1)).getAll();
        verifyNoMoreInteractions(bookingServiceMock);
	}

}