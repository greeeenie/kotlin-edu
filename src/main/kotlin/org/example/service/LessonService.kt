package org.example.service

import org.example.dto.LessonDto

interface LessonService {

    fun getAll(): List<LessonDto>

    fun create(lessonDto: LessonDto): LessonDto

    fun update(id: Int, lessonDto: LessonDto): LessonDto

    fun delete(id: Int)
}