package org.example.service.impl

import org.example.dto.LessonDto
import org.example.entity.LessonEntity
import org.example.mapper.toDto
import org.example.mapper.toEntity
import org.example.repository.LessonRepository
import org.example.service.LessonService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LessonServiceImpl(private val lessonRepository: LessonRepository) : LessonService {

    override fun getAll(): List<LessonDto> {
        return lessonRepository.findAll().map { it.toDto() }

    }

    override fun create(lessonDto: LessonDto): LessonDto {
        return lessonRepository.save(lessonDto.toEntity()).toDto()
    }

    override fun update(id: Int, lessonDto: LessonDto): LessonDto {
        val existingLesson = lessonRepository.findById(id)
            .orElseThrow { RuntimeException("Lesson not found") }
        existingLesson.name = lessonDto.name
        existingLesson.color = lessonDto.color
        existingLesson.daysLeft = lessonDto.daysLeft
        return lessonRepository.save(existingLesson).toDto()
    }

    override fun delete(id: Int) {
        lessonRepository.findById(id)
            .orElseThrow { RuntimeException("Lesson not found") }
        lessonRepository.deleteById(id)
    }


}
