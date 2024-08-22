package org.example.service.impl

import org.example.dto.LessonDto
import org.example.entity.LessonEntity
import org.example.repository.LessonRepository
import org.example.service.LessonService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LessonServiceImpl(private val lessonRepository: LessonRepository) : LessonService {

    override fun getAll(): List<LessonDto> {
        return lessonRepository.findAll().map { it.toDto() }

    }

    override fun create(lessonDto: LessonDto): Int? {
        return lessonRepository.save(lessonDto.toEntity()).id
    }

    override fun update(id: Int, lessonDto: LessonDto) {
        val existingLesson = lessonRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Lesson not found")

        existingLesson.name = lessonDto.name
        existingLesson.color = lessonDto.color
        existingLesson.daysLeft = lessonDto.daysLeft

        lessonRepository.save(existingLesson)
    }

    override fun delete(id: Int) {
        lessonRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Lesson not found")

        lessonRepository.deleteById(id)
    }

    private fun LessonEntity.toDto(): LessonDto =
        LessonDto(
            id = this.id,
            name = this.name,
            color = this.color,
            daysLeft = this.daysLeft,
        )

    private fun LessonDto.toEntity(): LessonEntity =
        LessonEntity(
            id = 0,
            name = this.name,
            color = this.color,
            daysLeft = this.daysLeft,
        )
}