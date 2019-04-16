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
import java.util.ArrayList;
import java.util.Arrays;

import com.pinchuk.resthotelbooking.controller.RoomController;
import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.Room;
import com.pinchuk.resthotelbooking.domain.RoomCategory;
import com.pinchuk.resthotelbooking.service.RoomService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RoomController.class)
public class RoomControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RoomService roomServiceMock;
	
	@Test
	public void getRoomsByCategory() throws Exception{
		RoomCategory roomCategory1 = new RoomCategory(1l, "Studio", new ArrayList<Room>());
		Room room1 = new Room(1l, "101", new BigDecimal(100), roomCategory1, new ArrayList<Booking>());
		
		
        when(roomServiceMock.getByRoomCategory(roomCategory1.getId())).thenReturn(Arrays.asList(room1));
        
        mockMvc.perform(get("/room/getRoomsByCategory?categoryId=" + roomCategory1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].number", is("101")))
                .andExpect(jsonPath("$[0].price", is(100)));
        
        verify(roomServiceMock, times(1)).getByRoomCategory(roomCategory1.getId());
        verifyNoMoreInteractions(roomServiceMock);
	}

}
