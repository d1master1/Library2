package org.example.library2.Impl;

import org.example.library2.entity.AuthorEntity;
import org.example.library2.repo.AuthorRepo;
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


/**
 * Тестирование бизнес-логики работы с авторами в системе
 */

@ExtendWith(MockitoExtension.class)
class AuthorImplTest {

    @Mock
    private AuthorRepo authorRepo;

    @InjectMocks
    private AuthorImpl authorService;

    /**
     * Метод для тестирования findById
     * Параметры:
     * @param id - идентификатор пользователя
     * @param name - имя пользователя
     * @param surName - фамилия пользователя
     * @param lastName - отчество пользователя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Петр, Петров",
            "3, Владиславович, Владислав, Владиславов",
            "4, Борисович, Борис, Борисов",
            "5, Петрович, Борис, Иванович"
    })
    void findById(Long id, String name, String lastName, String surName ) {

        AuthorEntity author = new AuthorEntity(id, lastName, name, surName);

        when(authorRepo.findById(id)).thenReturn(Optional.of(author));

        Optional<AuthorEntity> result = authorService.findById(id);
        System.out.printf("Результат: %s %s %s", result.get().getName(), result.get().getSurname(), result.get().getLastName());

        assertTrue(result.isPresent());
        assertEquals(name, result.get().getName());
        verify(authorRepo, times(1)).findById(id);
    }


    /**
     * Метод для тестирования сохранения пользователя в базу
     * @param id - идентификатор пользователя
     * @param name - имя пользователя
     * @param surName - фамилия пользователя
     * @param lastName - отчество пользователя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Петр, Петров",
            "3, Владиславович, Владислав, Владиславов",
            "4, Борисович, Борис, Борисов",
            "5, Петрович, Борис, Иванович"
    })
    void save(Long id, String name, String surName, String lastName) {
        AuthorEntity author = new AuthorEntity(id, lastName, name, surName);

        when(authorRepo.save(author)).thenReturn(author);

        AuthorEntity result = authorService.save(author);

        assertEquals(result, author);
    }

    /**
     * Метод для тестирования findAll
     * Параметры:
     * @param id - идентификатор пользователя
     * @param name - имя пользователя
     * @param surName - фамилия пользователя
     * @param lastName - отчество пользователя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Петр, Петров",
            "3, Владиславович, Владислав, Владиславов",
            "4, Борисович, Борис, Борисов",
            "5, Петрович, Борис, Иванович"
    })
    void findAll(Long id, String name, String surName, String lastName){
        List<AuthorEntity> authors = List.of(new AuthorEntity(id, lastName, name, surName));

        when(authorRepo.findAll()).thenReturn(authors);

        List<AuthorEntity> result = authorService.findAllAuthor();
        System.out.printf("Результат: %s %s %s \n", result.getFirst().getName(), result.getFirst().getSurname(), result.getFirst().getLastName());

        assertEquals(name, result.getFirst().getName());
        assertEquals(surName, result.getFirst().getSurname());
        assertEquals(lastName, result.getFirst().getLastName());
        verify(authorRepo, times(1)).findAll();

    }

    /**
     * Метод для тестирования update
     * Параметры:
     * @param id - идентификатор пользователя
     * @param name - имя пользователя
     * @param surName - фамилия пользователя
     * @param lastName - отчество пользователя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Петр, Петров",
            "3, Владиславович, Владислав, Владиславов",
            "4, Борисович, Борис, Борисов",
            "5, Петрович, Борис, Иванович"
    })
    void update(Long id, String name, String surName, String lastName){
        AuthorEntity author = new AuthorEntity(id, surName,name, lastName);
        authorService.update(author);
        verify(authorRepo, times(1)).save(author);
    }

    /**
     * Метод для тестирования delete
     * Параметры:
     * @param id - идентификатор пользователя
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Петр, Петров",
            "3, Владиславович, Владислав, Владиславов",
            "4, Борисович, Борис, Борисов",
            "5, Петрович, Борис, Иванович"
    })
    void delete(Long id){
        authorService.deleteById(id);
        verify(authorRepo, times(1)).deleteById(id);
    }

}