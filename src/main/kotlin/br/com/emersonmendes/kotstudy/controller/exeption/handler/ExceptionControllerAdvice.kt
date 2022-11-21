package br.com.emersonmendes.kotstudy.controller.exeption.handler

import br.com.emersonmendes.kotstudy.controller.exeption.ApiNotFoundException
import br.com.emersonmendes.kotstudy.controller.exeption.dto.ErrorMessageDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler( value = [ ApiNotFoundException::class ])
    fun handleNotFoundException(ex: ApiNotFoundException): ResponseEntity<ErrorMessageDto> {
        val errorMessage = ErrorMessageDto(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

}