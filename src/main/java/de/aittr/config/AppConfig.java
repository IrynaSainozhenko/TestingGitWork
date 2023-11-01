package de.aittr.config;

import de.aittr.repositories.UsersRepository;
import de.aittr.repositories.impl.UsersRepositoryArrayListImpl;
import de.aittr.repositories.impl.UsersRepositoryFileImpl;
import de.aittr.services.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 9/1/2023
 * SpringConsoleApplication
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Configuration
public class AppConfig {

    @Bean
    public UsersService usersService(UsersRepository usersRepositoryFile) {
        return new UsersService(usersRepositoryFile);
    }

    @Bean
    public UsersRepository usersRepositoryFile() {
        return new UsersRepositoryFileImpl();
    }

    @Bean
    public UsersRepository usersRepositoryArrayList() {
        return new UsersRepositoryArrayListImpl();
    }

}
