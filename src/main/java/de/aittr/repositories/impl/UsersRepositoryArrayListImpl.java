package de.aittr.repositories.impl;

import de.aittr.models.User;
import de.aittr.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 9/1/2023
 * SpringConsoleApplication
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersRepositoryArrayListImpl implements UsersRepository {

    private final ArrayList<User> users = new ArrayList<>(); // список пользователей, непосредственно хранилище пользователей

    @Override
    public void save(User user) { // create - создание, сохранение
        users.add(user); // если хотим сохранить пользователя, просто вызываем add-метод у списка
    }

    @Override
    public List<User> findAll() { // read - чтение, получение
        return new ArrayList<>(users); // возвращаем копию нашего списка, там будут все добавленные пользователи
    }

    @Override
    public User findByEmail(String email) { // read - чтение, получение
        for (User user : users) { // пробегаем всех пользователей
            if (user.getEmail().equals(email)) { // сравниваем email пользователя из списка с email-ом, который подали на вход
                return user; // если этот пользователь тот, кто нам нужен - возвращаем его
            }
        }
        return null; // если никого по этому email-у мы не нашли - возвращаем null
    }

}
