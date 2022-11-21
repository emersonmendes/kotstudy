package br.com.emersonmendes.kotstudy.domain

import javax.persistence.*

@Entity
data class Message (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val message: String

)