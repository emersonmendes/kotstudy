package br.com.emersonmendes.kotstudy.repository

import br.com.emersonmendes.kotstudy.domain.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CrudRepository<Message, Long> {

}