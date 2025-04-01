package org.example.library2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.library2.entity.PublisherEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publisher")
@Tag(name = "Издания", description = "API для управления изданиями")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список изданий", description = "Возвращает список изданий")
    public ResponseEntity<ListResponse<PublisherEntity>> getAllPublishers() {
        return ResponseEntity.ok(
                new ListResponse<PublisherEntity>(true, "Список издательств", publisherService.findAllPublisher()));
    }

    @GetMapping
    @Operation(summary = "Получить издания", description = "Возвращает издания по ID")
    public ResponseEntity<DataResponse<PublisherEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Найден следующий издатель", publisherService.findById(id).orElseThrow()));
    }

    @PostMapping
    @Operation(summary = "Сохранение изданий", description = "Возвращает сохранение изданий")
    public ResponseEntity<DataResponse<PublisherEntity>> save(@RequestBody PublisherEntity publisher) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Издатель сохранен", publisherService.save(publisher)));
    }

    @PutMapping
    @Operation(summary = "Обновление издания", description = "Возвращает обновление издания")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publisher) {
        publisherService.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издатель обновлен"));
    }

    @DeleteMapping
    @Operation(summary = "Удаление издания", description = "Возвращает удаление издания")
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издатель удален"));
    }
}