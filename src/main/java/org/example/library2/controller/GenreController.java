package org.example.library2.controller;

import org.example.library2.entity.GenreEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenreController {
    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<GenreEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<GenreEntity>(true, "Список акторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<GenreEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<GenreEntity>> save(@RequestBody GenreEntity genre) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Автор сохранен", service.save(genre)));
    }

    @PutMapping("/update-genre")
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        service.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }
}