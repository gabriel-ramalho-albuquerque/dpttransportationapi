package com.transportation.DPTTransport.Trip;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TripController.class)
public class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    private List<Trip> tripList;
    private Page<Trip> tripPage;

    @Before
    public void setUp(){
    }

    @Test
    public void getListYellow() throws Exception {
        Trip trip = new Trip();
        trip.setId(Long.valueOf(10402));
        trip.setPickupDateTime(LocalDate.parse("2018-01-01"));
        trip.setDropoffDateTime(LocalDate.parse("2018-01-01"));

        tripList = new ArrayList<>();
        tripList.add(trip);

        tripPage = new PageImpl<>(tripList);

        when(tripService.getListYellow(Long.valueOf(10402), null, null, PageRequest.of(0,1))).thenReturn(tripPage);

        mockMvc.perform(get("/api/v1/trip/list-yellow?page=0&size=10&sort=id,pickupDateTime&id=10402")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
