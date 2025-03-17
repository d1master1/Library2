package org.example.library2.controller;

import org.example.library2.entity.AuthorEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<AuthorEntity>> getAllAuthors() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список авторов", authorService.findAllAuthor()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<AuthorEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Найден следующий автор", authorService.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<AuthorEntity>> save(@RequestBody AuthorEntity author) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Автор сохранен", authorService.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        authorService.update(author);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор обновлен"));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор удален"));
    }
}