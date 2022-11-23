package br.com.emersonmendes.kotstudy.controller

import br.com.emersonmendes.kotstudy.domain.Message
import br.com.emersonmendes.kotstudy.repository.MessageRepository
import br.com.emersonmendes.kotstudy.service.MessageService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

@WebMvcTest
class MessageControllerTest(@Autowired val mockMvc: MockMvc){

    @MockkBean
    lateinit var messageService: MessageService

    @Test
    fun `should get message with status 200`() {

        val message = Optional.of(Message(1,"test"))

        every { messageService.getMessage(1) } returns message;

        mockMvc.perform(get("/messages/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.message").value("test"))

    }

}