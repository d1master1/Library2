package org.example.library2.Impl;

import org.example.library2.entity.BookEntity;
import org.example.library2.repo.BookRepo;
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

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookImpl bookImpl;

    /**
     * Метод для тестирования findById
     * Параметры:
     *
     * @param id   - идентификатор книги
     * @param year - год книги
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1991",
            "2, 1992",
            "3, 1993",
            "4, 1994",
            "5, 1995"
    })
    void findById(Long id, String year) {

        BookEntity books = new BookEntity(id, year);

        when(bookRepo.findById(id)).thenReturn(Optional.of(books));

        Optional<BookEntity> result = bookRepo.findById(id);
        System.out.printf("Результат: %s \n", result.get().getYear());

        assertTrue(result.isPresent());
        assertEquals(year, result.get().getYear());
        verify(bookRepo, times(1)).findById(id);
    }


    /**
     * Метод для тестирования сохранения кинги в базу
     *
     * @param id   - идентификатор книги
     * @param year - год книги
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1991",
            "2, 1992",
            "3, 1993",
            "4, 1994",
            "5, 1995"
    })
    void save(Long id, String year) {
        BookEntity book = new BookEntity(id, year);

        when(bookRepo.save(book)).thenReturn(book);

        BookEntity result = bookImpl.save(book);

        assertEquals(result, book);
    }

    /**
     * Метод для тестирования findAll
     * Параметры:
     *
     * @param id   - идентификатор книги
     * @param year - год книги
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1991",
            "2, 1992",
            "3, 1993",
            "4, 1994",
            "5, 1995"
    })
    void findAll(Long id, String year) {
        List<BookEntity> book = List.of(new BookEntity(id, year));

        when(bookImpl.findAllBook()).thenReturn(book);

        List<BookEntity> result = bookImpl.findAllBook();
        System.out.printf("Результат: %s \n", result.getFirst().getYear());

        assertEquals(year, result.getFirst().getYear());
        verify(bookRepo, times(1)).findAll();

    }

    /**
     * Метод для тестирования update
     * Параметры:
     *
     * @param id   - идентификатор книги
     * @param year - год книги
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1991",
            "2, 1992",
            "3, 1993",
            "4, 1994",
            "5, 1995"
    })
    void update(Long id, String year) {
        BookEntity book = new BookEntity(id, year);
        bookImpl.update(book);
        verify(bookRepo, times(1)).save(book);
    }

    /**
     * Метод для тестирования delete
     * Параметры:
     * @param id - идентификатор книги
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1991",
            "2, 1992",
            "3, 1993",
            "4, 1994",
            "5, 1995"
    })
    void delete(Long id) {
        bookImpl.deleteById(id);
        verify(bookRepo, times(1)).deleteById(id);
    }
}