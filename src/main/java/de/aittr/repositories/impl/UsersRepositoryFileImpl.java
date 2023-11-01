package de.aittr.repositories.impl;

import de.aittr.models.User;
import de.aittr.repositories.UsersRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 9/1/2023
 * SpringConsoleApplication
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersRepositoryFileImpl implements UsersRepository {

    private final String fileName; // имя файла, в который будем писать и откуда будем читать

    public UsersRepositoryFileImpl() {
        this.fileName = "users.txt";
    }

    @Override
    public void save(User user) { // create - создание, сохранение
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(user.getEmail() + "#" + user.getPassword()); // записываем строку в файл
            writer.newLine();// делаем переход на новую строку, чтобы следующая запись начиналась с новой строки
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() { // read - чтение, получение
        return null;
    }

    @Override
    public User findByEmail(String email) { // read - чтение, получение
        return null;
    }

}
