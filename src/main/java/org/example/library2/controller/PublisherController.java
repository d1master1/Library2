package org.example.library2.controller;

import org.example.library2.entity.PublisherEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublisherController {
    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<PublisherEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<PublisherEntity>(true, "Список акторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<PublisherEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<PublisherEntity>> save(@RequestBody PublisherEntity publisher) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Автор сохранен", service.save(publisher)));
    }

    @PutMapping("/update-publisher")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publisher) {
        service.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }
}