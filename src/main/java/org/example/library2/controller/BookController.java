package org.example.library2.controller;

import org.example.library2.entity.BookEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<BookEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<BookEntity>(true, "Список акторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<BookEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<BookEntity>> save(@RequestBody BookEntity book) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Автор сохранен", service.save(book)));
    }

    @PutMapping("/update-book")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity book) {
        service.update(book);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }
}