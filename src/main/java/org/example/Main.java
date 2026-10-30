package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Main {
    static List<User> users = new ArrayList<>();
    static List<String> books = new ArrayList<>();
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        User user_date = new User();

        String hello = "Hello, " + user_date.name + "\n" +
                "Чего желаите ?\n" +
                "1 - Cохранение пароля пользователя\n" +
                "2 - Извлечение\n" +
                "3 - Обновление\n" +
                "4 - Удаление\n" +
                "0 - Выход" +
                "Выберете от 1 до 4";


        int chose;
        int [] rezult = new int[2];

        IO.println(hello);
        while (true) {
            IO.println("И так...");
            if (scan.hasNextInt()) {
                chose = scan.nextInt();
            } else {
                IO.println("Не корректное значение");
                scan.next();
                continue;
            }
            String chose_name;
            switch (chose) {
                case 1:
                    user_date = new User();
                    IO.println("Имя");
                    user_date.name = scan.next();
                    IO.println("Пароль");
                    if (scan.hasNextInt()) {
                        user_date.password = scan.nextInt();
                    } else {
                        IO.println("Не корректное значение");
                        scan.next();
                        continue;
                    }
                    rezult = Users_data.getInAllInfo(user_date, users);

                    if (rezult[1] == 0) {
                        users.add(rezult[0] ,user_date);
                        IO.println("Saved");
                    } else if (rezult[1] == 1) {
                        IO.println("User is is");
                    };
                    break;

                case 2:
                    rezult = Users_data.getInAllInfo(user_date, users);
                    if (rezult[1] == 1) {
                        IO.println(users.get(rezult[0]).password);
                    } else if (rezult[1] == 0) {
                        IO.println("No such User");
                    }
                    break;
                case 3:
                    rezult = Users_data.getInAllInfo(user_date, users);
                    if (rezult[1] == 1) {
                        IO.println("Введите новый пароль...");
                        if (scan.hasNextInt()) {
                            users.get(rezult[0]).password = scan.nextInt();
                            user_date = users.get(rezult[0]);
                        } else {
                            IO.println("Не корректное значение");
                            scan.next();
                            continue;
                        }
                        IO.println("Saved");
                    } else if (rezult[1] == 0) {
                        IO.println("No such User");
                    }
                    break;
                case 4:
                    rezult = Users_data.getInAllInfo(user_date, users);
                    if (rezult[1] == 1) {
                        users.remove(rezult[0]);
                        IO.println("Removed");
                    } else if (rezult[1] == 0) {
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
                    IO.println("Не корректная команда");

            }
        }

    }
}
