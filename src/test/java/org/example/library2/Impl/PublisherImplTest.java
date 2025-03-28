package org.example.library2.Impl;

import org.example.library2.entity.PublisherEntity;
import org.example.library2.repo.PublisherRepo;
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
 * Тестирование бизнес-логики работы с издателями в системе
 */

@ExtendWith(MockitoExtension.class)
class PublisherServiceTest {

    @Mock
    private PublisherRepo publisherRepo;

    @InjectMocks
    private PublisherImpl publisherService;

    /**
     * Метод для тестирования findById
     * Параметры:
     * @param id - идентификатор издателя
     * @param title - наименование издателя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Литрес",
            "2, Совиная Сказка",
            "3, Arctic Ice ",
            "4, Эксмо",
            "5, Союз писателей"
    })
    void findById(Long id, String title ) {

        PublisherEntity publishers = new PublisherEntity(id, title);

        when(publisherRepo.findById(id)).thenReturn(Optional.of(publishers));

        Optional<PublisherEntity> result = publisherRepo.findById(id);
        System.out.printf("Результат: %s \n", result.get().getTitle());

        assertTrue(result.isPresent());
        assertEquals(title, result.get().getTitle());
        verify(publisherRepo, times(1)).findById(id);
    }


    /**
     * Метод для тестирования сохранения издателя в базу
     * @param id - идентификатор издателя
     * @param title - наименование издателя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Литрес",
            "2, Совиная Сказка",
            "3, Arctic Ice ",
            "4, Эксмо",
            "5, Союз писателей"
    })
    void save(Long id, String title) {
        PublisherEntity publishers = new PublisherEntity(id, title);

        when(publisherRepo.save(publishers)).thenReturn(publishers);

        PublisherEntity result = publisherRepo.save(publishers);

        assertEquals(result, publishers);
    }

    /**
     * Метод для тестирования findAll
     * Параметры:
     * @param id - идентификатор издателя
     * @param title - наименование издателя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Литрес",
            "2, Совиная Сказка",
            "3, Arctic Ice ",
            "4, Эксмо",
            "5, Союз писателей"
    })
    void findAll(Long id, String title){
        List<PublisherEntity> publishers = List.of(new PublisherEntity(id, title));

        when(publisherRepo.findAll()).thenReturn(publishers);

        List<PublisherEntity> result = publisherService.findAllPublisher();
        System.out.printf("Результат: %s \n", result.getFirst().getTitle());

        assertEquals(title, result.getFirst().getTitle());
        verify(publisherRepo, times(1)).findAll();

    }

    /**
     * Метод для тестирования update
     * Параметры:
     * @param id - идентификатор издателя
     * @param title - наименование издателя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Литрес",
            "2, Совиная Сказка",
            "3, Arctic Ice ",
            "4, Эксмо",
            "5, Союз писателей"
    })
    void update(Long id, String title){
        PublisherEntity publishers = new PublisherEntity(id, title);
        publisherService.update(publishers);
        verify(publisherRepo, times(1)).save(publishers);
    }

    /**
     * Метод для тестирования delete
     * Параметры:
     * @param id - идентификатор издателя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Литрес",
            "2, Совиная Сказка",
            "3, Arctic Ice ",
            "4, Эксмо",
            "5, Союз писателей"
    })
    void delete(Long id){
        publisherService.deleteById(id);
        verify(publisherRepo, times(1)).deleteById(id);
    }

}