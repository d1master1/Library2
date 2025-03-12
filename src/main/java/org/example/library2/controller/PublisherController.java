package org.example.library2.controller;

//Доделать по аналогии

/*
@RestController
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<AuthorEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список акторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<AuthorEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<AuthorEntity>> save(@RequestBody AuthorEntity author) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Автор сохранен", service.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        service.update(author);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }
}*/
