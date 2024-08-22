package org.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "lessons")
data class LessonEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "color")
    var color: String? = null,

    @Column(name = "days_left")
    var daysLeft: Int? = null,
    )