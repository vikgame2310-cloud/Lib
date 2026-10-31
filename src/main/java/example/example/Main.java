
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User user_date = null;

        String hello = """
                Менеджер паролей
                1 - Сохранение пароля / Вход
                2 - Извлечение
                3 - Обновление
                4 - Удаление
                5 - Показать меню
                0 - Выход
                """;

        IO.println(hello);

        while (true) {
            IO.println("И так...");

            if (!scan.hasNextInt()) {
                IO.println("Некорректное значение");
                scan.next();
                continue;
            }

            int chose = scan.nextInt();

            switch (chose) {
                case 1:
                    User newUser = new User();

                    IO.println("Имя");
                    newUser.name = scan.next();

                    IO.println("Пароль");
                    if (!scan.hasNextInt()) {
                        IO.println("Некорректное значение");
                        scan.next();
                        break;
                    }

                    newUser.password = scan.nextInt();

                    int status = Functions.saveOrCreateUser(newUser, users);

                    if (status == 0) {
                        user_date = newUser;
                        IO.println("Saved");
                    } else if (status == 1) {
                        user_date = newUser;
                        IO.println("Вход выполнен");
                    } else {
                        IO.println("Доступ не предоставлен");
                    }
                    break;

                case 2:
                    if (user_date == null) {
                        IO.println("Сначала войдите в аккаунт");
                        break;
                    }

                    Integer password = Functions.getPassword(user_date, users);

                    if (password != null) {
                        IO.println(password);
                    } else {
                        IO.println("No such User");
                    }
                    break;

                case 3:
                    if (user_date == null) {
                        IO.println("Сначала войдите в аккаунт");
                        break;
                    }

                    IO.println("Введите новый пароль...");

                    if (!scan.hasNextInt()) {
                        IO.println("Некорректное значение");
                        scan.next();
                        break;
                    }

                    int newPassword = scan.nextInt();

                    if (Functions.updatePassword(user_date, newPassword, users)) {
                        IO.println("Saved");
                    } else {
                        IO.println("No such User");
                    }
                    break;

                case 4:
                    if (user_date == null) {
                        IO.println("Сначала войдите в аккаунт");
                        break;
                    }

                    if (Functions.deleteUser(user_date, users)) {
                        user_date = null;
                        IO.println("Removed");
                    } else {
                        IO.println("No such User");
                    }
                    break;

                case 5:
                    IO.println(hello);
                    break;

                case 0:
                    IO.println("Goodbye!");
                    return;

                default:
                    IO.println("Некорректная команда");
            }
        }
    }
}
