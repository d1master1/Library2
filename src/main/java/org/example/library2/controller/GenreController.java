package org.example.library2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.library2.entity.GenreEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/genre")
@Tag(name = "Жанры", description = "API для управления жанрами")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список жанров", description = "Возвращает список жанров")
    public ResponseEntity<ListResponse<GenreEntity>> getAllGenres() {
        return ResponseEntity.ok(
                new ListResponse<GenreEntity>(true, "Список жанров", genreService.findAllGenre()));
    }

    @GetMapping
    @Operation(summary = "Получить жанр", description = "Возвращает жанр по ID")
    public ResponseEntity<DataResponse<GenreEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий жанр", genreService.findById(id).orElseThrow()));
    }

    @PostMapping
    @Operation(summary = "Сохранение жанра", description = "Возвращает сохранение жанра")
    public ResponseEntity<DataResponse<GenreEntity>> save(@RequestBody GenreEntity genre) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Жанр сохранен", genreService.save(genre)));
    }

    @PutMapping
    @Operation(summary = "Обновление жанра", description = "Возвращает обновление жанра")
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        genreService.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр обновлен"));
    }

    @DeleteMapping
    @Operation(summary = "Удаление жанра", description = "Возвращает удаление жанра")
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        genreService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр удален"));
    }
}