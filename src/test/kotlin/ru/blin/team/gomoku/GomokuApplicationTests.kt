package ru.blin.team.gomoku

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import ru.blin.team.gomoku.entity.ResponseMessage
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.http.MediaType



@SpringBootTest
@AutoConfigureMockMvc
class GomokuApplicationTests {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun shouldSayHello() {
        assertThat(mockMvc).isNotNull
        val validMockMvc = mockMvc as MockMvc
        val testName = "Fedya"
        val expectedResponse = ResponseMessage("Hello, $testName")
        validMockMvc.perform(get("/hello").param("name", testName))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json(Json.encodeToString(expectedResponse)))
    }

    @Test
    fun missingNameSayHello() {
        assertThat(mockMvc).isNotNull
        val validMockMvc = mockMvc as MockMvc
        validMockMvc.perform(get("/hello"))
            .andExpect(status().isBadRequest)
    }
}
