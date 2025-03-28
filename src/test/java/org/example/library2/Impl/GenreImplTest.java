package org.example.library2.Impl;

import org.example.library2.entity.GenreEntity;
import org.example.library2.repo.GenreRepo;
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
 * Тестирование бизнес-логики работы с жанрами в системе
 */

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {

    @Mock
    private GenreRepo genreRepo;

    @InjectMocks
    private GenreImpl genreService;

    /**
     * Метод для тестирования findById
     * Параметры:
     * @param id - идентификатор жанра
     * @param title - Название жанра
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Классика",
            "2, Детектив",
            "3, Фэнтези",
            "4, Ужасы",
            "5, Комедии"
    })
    void findById(Long id, String title ) {

        GenreEntity genres = new GenreEntity(id, title);

        when(genreRepo.findById(id)).thenReturn(Optional.of(genres));

        Optional<GenreEntity> result = genreRepo.findById(id);
        System.out.printf("Результат: %s \n", result.get().getTitle());

        assertTrue(result.isPresent());
        assertEquals(title, result.get().getTitle());
        verify(genreRepo, times(1)).findById(id);
    }


    /**
     * Метод для тестирования сохранения жанра в базу
     * @param id - идентификатор жанра
     * @param title - название жанра
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Классика",
            "2, Детектив",
            "3, Фэнтези",
            "4, Ужасы",
            "5, Комедии"
    })
    void save(Long id, String title) {
        GenreEntity genres = new GenreEntity(id, title);

        when(genreRepo.save(genres)).thenReturn(genres);

        GenreEntity result = genreRepo.save(genres);

        assertEquals(result, genres);
    }

    /**
     * Метод для тестирования findAll
     * Параметры:
     * @param id - идентификатор жанра
     * @param title - название жанра
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Классика",
            "2, Детектив",
            "3, Фэнтези",
            "4, Ужасы",
            "5, Комедии"
    })
    void findAll(Long id, String title){
        List<GenreEntity> genres = List.of(new GenreEntity(id, title));

        when(genreService.findAllGenre()).thenReturn(genres);

        List<GenreEntity> result = genreService.findAllGenre();
        System.out.printf("Результат: %s \n", result.getFirst().getTitle());

        assertEquals(title, result.getFirst().getTitle());
        verify(genreRepo, times(1)).findAll();

    }

    /**
     * Метод для тестирования update
     * Параметры:
     * @param id - идентификатор жанра
     * @param title - название жанра
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Классика",
            "2, Детектив",
            "3, Фэнтези",
            "4, Ужасы",
            "5, Комедии"
    })
    void update(Long id, String title){
        GenreEntity genres = new GenreEntity(id, title);
        genreService.update(genres);
        verify(genreRepo, times(1)).save(genres);
    }

    /**
     * Метод для тестирования delete
     * Параметры:
     * @param id - идентификатор жанра
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Классика",
            "2, Детектив",
            "3, Фэнтези",
            "4, Ужасы",
            "5, Комедии"
    })
    void delete(Long id){
        genreService.deleteById(id);
        verify(genreRepo, times(1)).deleteById(id);
    }

}