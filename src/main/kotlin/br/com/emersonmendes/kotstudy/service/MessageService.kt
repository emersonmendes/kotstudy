package br.com.emersonmendes.kotstudy.service

import br.com.emersonmendes.kotstudy.domain.Message
import br.com.emersonmendes.kotstudy.repository.MessageRepositry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService {

    @Autowired
    private lateinit var repository: MessageRepositry

    fun getMessages(): Iterable<Message> {
        return repository.findAll()
    }

    fun getMessage(id: Long): Optional<Message> {
        return repository.findById(id)
    }

    fun save(message: Message): Message {
        return repository.save(message)
    }

}