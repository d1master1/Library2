package org.example.library2.Impl;

import org.example.library2.entity.CityEntity;
import org.example.library2.repo.CityRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Тестирование бизнес-логики работы с городами в системе
 */

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    private CityRepo cityRepo;

    @InjectMocks
    private CityImpl cityService;

    /**
     * Метод для тестирования findById
     * Параметры:
     * @param id - идентификатор города
     * @param title - название города
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Москва",
            "2, Санкт-Петербург",
            "3, Омск",
            "4, Тула",
            "5, Владивосток"
    })
    void findById(Long id, String title ) {

        CityEntity citys = new CityEntity(id, title);

        when(cityRepo.findById(id)).thenReturn(Optional.of(citys));

        Optional<CityEntity> result = cityRepo.findById(id);
        System.out.printf("Результат: %s \n", result.get().getTitle());

        assertTrue(result.isPresent());
        assertEquals(title, result.get().getTitle());
        verify(cityRepo, times(1)).findById(id);
    }


    /**
     * Метод для тестирования сохранения города в базу
     * @param id - идентификатор города
     * @param title - название города
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Москва",
            "2, Санкт-Петербург",
            "3, Омск",
            "4, Тула",
            "5, Владивосток"
    })
    void save(Long id, String title) {
        CityEntity citys = new CityEntity(id, title);

        when(cityRepo.save(citys)).thenReturn(citys);

        CityEntity result = cityService.save(citys);

        assertEquals(result, citys);
    }

    /**
     * Метод для тестирования findAll
     * Параметры:
     * @param id - идентификатор города
     * @param title - название города
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Москва",
            "2, Санкт-Петербург",
            "3, Омск",
            "4, Тула",
            "5, Владивосток"
    })
    void findAll(Long id, String title){
        List<CityEntity> citys = List.of(new CityEntity(id, title));

        when(cityService.findAllCity()).thenReturn(citys);

        List<CityEntity> result = cityService.findAllCity();
        System.out.printf("Результат: %s \n", result.getFirst().getTitle());

        assertEquals(title, result.getFirst().getTitle());
        verify(cityRepo, times(1)).findAll();

    }

    /**
     * Метод для тестирования update
     * Параметры:
     * @param id - идентификатор города
     * @param title - название города
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Москва",
            "2, Санкт-Петербург",
            "3, Омск",
            "4, Тула",
            "5, Владивосток"
    })
    void update(Long id, String title){
        CityEntity citys = new CityEntity(id, title);
        cityService.update(citys);
        verify(cityRepo, times(1)).save(citys);
    }

    /**
     * Метод для тестирования delete
     * Параметры:
     * @param id - идентификатор города
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Москва",
            "2, Санкт-Петербург",
            "3, Омск",
            "4, Тула",
            "5, Владивосток"
    })
    void delete(Long id){
        cityService.deleteById(id);
        verify(cityRepo, times(1)).deleteById(id);
    }

}