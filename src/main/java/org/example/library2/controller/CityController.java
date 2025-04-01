package org.example.library2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.library2.entity.CityEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
@Tag(name = "Города", description = "API для управления городами")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список городов", description = "Возвращает список городов")
    public ResponseEntity<ListResponse<CityEntity>> getAllCities() {
        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список городов", cityService.findAllCity()));
    }

    @GetMapping
    @Operation(summary = "Получить город", description = "Возвращает город по ID")
    public ResponseEntity<DataResponse<CityEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий город", cityService.findById(id).orElseThrow()));
    }

    @PostMapping
    @Operation(summary = "Сохранение города", description = "Возвращает сохранение города")
    public ResponseEntity<DataResponse<CityEntity>> save(@RequestBody CityEntity city) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Город сохранен", cityService.save(city)));
    }

    @PutMapping
    @Operation(summary = "Обновление города", description = "Возвращает обновление города")
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        cityService.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город обновлен"));
    }

    @DeleteMapping
    @Operation(summary = "Удаление города", description = "Возвращает удаление города")
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        cityService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город удален"));
    }
}