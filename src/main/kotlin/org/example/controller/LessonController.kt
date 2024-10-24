package org.example.controller

import org.example.dto.LessonDto
import org.example.service.LessonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/lessons")
class LessonController(
    private val lessonService: LessonService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<LessonDto>> = ResponseEntity.ok(lessonService.getAll())

    @PostMapping
    fun create(@RequestBody lessonDto: LessonDto): ResponseEntity<LessonDto> {
        val createdLesson = lessonService.create(lessonDto)
        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdLesson.id)
                .toUri()
        ).body(createdLesson)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody lessonDto: LessonDto): ResponseEntity<LessonDto> = ResponseEntity.ok(lessonService.update(id, lessonDto))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) = lessonService.delete(id)

}