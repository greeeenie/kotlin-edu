package org.example.repository

import org.example.entity.LessonEntity
import org.springframework.data.repository.CrudRepository

interface LessonRepository: CrudRepository<LessonEntity, Int>
