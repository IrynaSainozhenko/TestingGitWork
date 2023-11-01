package de.aittr.repositories;

import de.aittr.models.User;

import java.util.List;

public interface UsersRepository {
    void save(User user);
    User findByEmail(String email);

    List<User> findAll();
}
