package de.aittr;

import de.aittr.models.User;
import de.aittr.repositories.impl.UsersRepositoryArrayListImpl;
import de.aittr.repositories.impl.UsersRepositoryFileImpl;
import de.aittr.services.UsersService;

import java.util.List;
import java.util.Scanner;

/**
 * 9/1/2023
 * SpringConsoleApplication
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsersRepositoryArrayListImpl usersRepositoryArrayList = new UsersRepositoryArrayListImpl();
        UsersRepositoryFileImpl usersRepositoryFile = new UsersRepositoryFileImpl();

        UsersService usersService = new UsersService(usersRepositoryFile);

        while (true) {
            System.out.println("1. Добавление пользователя");
            System.out.println("2. Поиск пользователя");
            System.out.println("3. Получение всех пользователей");
            System.out.println("0. Выход");

            int command = scanner.nextInt(); // считали номер команды
            scanner.nextLine(); // пропуск пустой строки

            if (command == 1) {
                System.out.println("Введите email пользователя:");
                String email = scanner.nextLine();
                System.out.println("Введите пароль пользователя:");
                String password = scanner.nextLine();

                usersService.register(email, password);
            } else if (command == 2) {
                System.out.println("Пока не реализовано");
            } else if (command == 3) {
                // получаем из сервиса всех пользователей
                List<User> users = usersService.getAllUsers();
                // печатаем этих пользователей
                System.out.println(users);
            } else if (command == 0) {
                System.exit(0); // останавливаем работу программы
            } else {
                System.err.println("Команда не распознана");
            }
        }
    }
}
