package com.scottishpower.digital.smart.meter.service.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SmartMeterReadingResourceIT {

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
  }

  @Test
  void getSmartMeterReadingsByAccount() throws Exception {
    mockMvc.perform(get("/api/smart/reads/000000001")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", equalTo("f2e2a8e2-d060-4419-bb96-6e52c2cdcc63")))
        .andExpect(jsonPath("$[0].gasRead", notNullValue()))
        .andExpect(jsonPath("$[0].electricityRead", notNullValue()))
        .andExpect(jsonPath("$[1].id", equalTo("e649c997-dc64-4d07-98df-97caf1601ee5")))
        .andExpect(jsonPath("$[1].gasRead", notNullValue()))
        .andExpect(jsonPath("$[1].electricityRead", notNullValue()));
  }
}