package br.com.emersonmendes.kotstudy.service

import br.com.emersonmendes.kotstudy.domain.Message
import br.com.emersonmendes.kotstudy.repository.MessageRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.test.util.AssertionErrors.assertEquals
import java.util.Optional


class MessageServiceTest {

    val messageRepository: MessageRepository = mockk()

    val messageService = MessageService(messageRepository)

    @Test
    fun `should find a message by id`() {

//        val message = Optional.of(mockk<Message>(relaxed = true))
        val message = Optional.of(Message(1,"test"))
        //given
        every {
            messageRepository.findById(1)
        } returns message

        //when
        val result = messageService.getMessage(1);

        //then
        verify(exactly = 1) {
            messageRepository.findById(1)
        }

        assertEquals("", message.get().message, result.get().message)

    }

}