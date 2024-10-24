package org.example.mapper

import org.example.dto.LessonDto
import org.example.entity.LessonEntity

fun LessonEntity.toDto(): LessonDto =
    LessonDto(
        id = this.id,
        name = this.name,
        color = this.color,
        daysLeft = this.daysLeft,
    )

fun LessonDto.toEntity(): LessonEntity =
    LessonEntity(
        id = 0,
        name = this.name,
        color = this.color,
        daysLeft = this.daysLeft,
    )
