package br.com.emersonmendes.kotstudy.controller

import br.com.emersonmendes.kotstudy.controller.exeption.ApiNotFoundException
import br.com.emersonmendes.kotstudy.domain.Message
import br.com.emersonmendes.kotstudy.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/messages")
class MessageController {

    @Autowired
    private lateinit var service: MessageService

    @GetMapping
    fun getMessages() : Iterable<Message> {
       return service.getMessages()
    }

    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: Long) : Any? {
        val message = service.getMessage(id)
        if(message.isEmpty){
            throw ApiNotFoundException("Message with id: $id was not found")
        }
        return message
    }

    @PostMapping
    fun saveMessage(@RequestBody message: Message) : ResponseEntity<Message> {
        val (id) = service.save(message)
        val uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri()
        return ResponseEntity.created(uri).build()
    }

}