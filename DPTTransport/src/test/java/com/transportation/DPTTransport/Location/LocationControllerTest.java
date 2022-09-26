package com.transportation.DPTTransport.Location;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    private List<TopZoneDTO> topZoneDTOList;

    private List<ZoneTripsDTO> zoneTripsDTOList;

    @Before
    public void setUp(){
    }

    @Test
    public void getTopZonesByPickUps() throws Exception {
        topZoneDTOList = new ArrayList<>();

        topZoneDTOList.add(new TopZoneDTO("Lincoln Square East", BigInteger.valueOf(449), BigInteger.valueOf(217)));
        topZoneDTOList.add(new TopZoneDTO("East Village", BigInteger.valueOf(432), BigInteger.valueOf(309)));
        topZoneDTOList.add(new TopZoneDTO("Midtown Center", BigInteger.valueOf(426), BigInteger.valueOf(177)));
        topZoneDTOList.add(new TopZoneDTO("Upper East Side South", BigInteger.valueOf(417), BigInteger.valueOf(209)));
        topZoneDTOList.add(new TopZoneDTO("Upper West Side South", BigInteger.valueOf(411), BigInteger.valueOf(325)));

        when(locationService.getTopZones(any())).thenReturn(topZoneDTOList);

        mockMvc.perform(get("/api/v1/location/top-zones?order=pickups")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(5)))
                        .andExpect(jsonPath("$.[0].zone").value(topZoneDTOList.get(0).getZone()))
                        .andExpect(jsonPath("$.[0].puTotal").value(topZoneDTOList.get(0).getPuTotal()))
                        .andExpect(jsonPath("$.[0].doTotal").value(topZoneDTOList.get(0).getDoTotal()))
                        .andDo(print());
    }

    @Test
    public void getTopZonesByDropOffs() throws Exception {
        topZoneDTOList = new ArrayList<>();

        topZoneDTOList.add(new TopZoneDTO("Murray Hill", BigInteger.valueOf(362), BigInteger.valueOf(429)));
        topZoneDTOList.add(new TopZoneDTO("Upper West Side North", BigInteger.valueOf(285), BigInteger.valueOf(361)));
        topZoneDTOList.add(new TopZoneDTO("Yorkville West", BigInteger.valueOf(321), BigInteger.valueOf(332)));
        topZoneDTOList.add(new TopZoneDTO("Upper West Side South", BigInteger.valueOf(411), BigInteger.valueOf(325)));
        topZoneDTOList.add(new TopZoneDTO("Clinton East", BigInteger.valueOf(350), BigInteger.valueOf(320)));

        when(locationService.getTopZones(any())).thenReturn(topZoneDTOList);

        mockMvc.perform(get("/api/v1/location/top-zones?order=dropoffs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(5)))
                .andExpect(jsonPath("$.[0].zone").value(topZoneDTOList.get(0).getZone()))
                .andExpect(jsonPath("$.[0].puTotal").value(topZoneDTOList.get(0).getPuTotal()))
                .andExpect(jsonPath("$.[0].doTotal").value(topZoneDTOList.get(0).getDoTotal()))
                .andDo(print());
    }

    @Test
    public void getZoneTrips() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        zoneTripsDTOList = new ArrayList<>();

        zoneTripsDTOList.add(new ZoneTripsDTO("Alphabet City", formatter.parse("2018-01-01"), BigInteger.valueOf(61), BigInteger.valueOf(70)));

        when(locationService.getZoneTrips(Long.valueOf(4), LocalDate.parse(("2018-01-01")))).thenReturn(zoneTripsDTOList);

        mockMvc.perform(get("/api/v1/location/zone-trips?zone=4&date=2018-01-01")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].zone").value(zoneTripsDTOList.get(0).getZone()))
                .andExpect(jsonPath("$.[0].date").isNotEmpty())
                .andExpect(jsonPath("$.[0].puSum").value(zoneTripsDTOList.get(0).getPuSum()))
                .andExpect(jsonPath("$.[0].doSum").value(zoneTripsDTOList.get(0).getDoSum()))
                .andDo(print());
    }

}
