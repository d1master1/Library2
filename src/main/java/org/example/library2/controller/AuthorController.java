package org.example.library2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.library2.entity.AuthorEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
@Tag(name = "Авторы", description = "API для управления авторами")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список авторов", description = "Возвращает список авторов")
    public ResponseEntity<ListResponse<AuthorEntity>> getAllAuthors() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список авторов", authorService.findAllAuthor()));
    }

    @GetMapping
    @Operation(summary = "Получить автора", description = "Возвращает автора по ID")
    public ResponseEntity<DataResponse<AuthorEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Найден следующий автор", authorService.findById(id).orElseThrow()));
    }

    @PostMapping
    @Operation(summary = "Сохранение автора", description = "Возвращает сохранение автора")
    public ResponseEntity<DataResponse<AuthorEntity>> save(@RequestBody AuthorEntity author) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Автор сохранен", authorService.save(author)));
    }

    @PutMapping
    @Operation(summary = "Обновление автора", description = "Возвращает обновление автора")
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        authorService.update(author);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор обновлен"));
    }

    @DeleteMapping
    @Operation(summary = "Удаление автора", description = "Возвращает удаление автора")
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор удален"));
    }
}