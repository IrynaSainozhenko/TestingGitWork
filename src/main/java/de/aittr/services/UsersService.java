package de.aittr.services;

import de.aittr.models.User;
import de.aittr.repositories.UsersRepository;
import de.aittr.repositories.impl.UsersRepositoryFileImpl;

import java.util.List;

/**
 * 9/1/2023
 * SpringConsoleApplication
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void register(String email, String password) {
        if (isEmptyOrBlankOrNull(email) || !email.contains("@")) {
            throw new IllegalArgumentException("Плохой формат email-а");
        }

        if (isEmptyOrBlankOrNull(password) || password.length() < 7) {
            throw new IllegalArgumentException("Плохой пароль");
        }

        if (usersRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Пользователь с таким email-ом уже есть");
        }

        // если ни одно исключение выше выброшено не было - значит все хорошо
        // создаем пользователя и сохраняем его

        // создаем пользователя с этими данными
        User user = new User(email, password);
        // сохраняем его
        usersRepository.save(user);
    }

    public List<User> getAllUsers() {
        // метод для получения всех пользователей
        return usersRepository.findAll(); // по итогу мы просто обернули репозиторий в сервис в данном случае
    }

    private boolean isEmptyOrBlankOrNull(String value) {
        return value == null || value.isEmpty() || value.isBlank();
    }
}
