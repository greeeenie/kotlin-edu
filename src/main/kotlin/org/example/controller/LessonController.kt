package org.example.controller

import org.example.dto.LessonDto
import org.example.service.LessonService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lessons")
class LessonController(
    private val lessonService: LessonService
) {
    @GetMapping("/all")
    fun getAll(): List<LessonDto> {
        return lessonService.getAll()
    }

    @PostMapping("/create")
    fun create(@RequestBody lessonDto: LessonDto): Int? {
        return lessonService.create(lessonDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody lessonDto: LessonDto) {
        return lessonService.update(id, lessonDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        return lessonService.delete(id)
    }
}