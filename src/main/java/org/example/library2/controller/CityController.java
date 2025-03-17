package org.example.library2.controller;

import org.example.library2.entity.CityEntity;
import org.example.library2.response.BaseResponse;
import org.example.library2.response.DataResponse;
import org.example.library2.response.ListResponse;
import org.example.library2.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<CityEntity>> getAllCities() {
        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список городов", cityService.findAllCity()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<CityEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий город", cityService.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<CityEntity>> save(@RequestBody CityEntity city) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Город сохранен", cityService.save(city)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        cityService.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город обновлен"));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        cityService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город удален"));
    }
}