package org.example.library2.controller;

import org.example.library2.entity.CityEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<CityEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список акторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<CityEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<CityEntity>> save(@RequestBody CityEntity city) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Автор сохранен", service.save(city)));
    }

    @PutMapping("/update-city")
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        service.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }
}