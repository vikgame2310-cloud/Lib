
package example.example;

import java.util.List;

public class Functions {

    // Создание записи или вход
    public static int saveOrCreateUser(User user, List<User> users) {
        int[] result = Users_data.getInAllInfo(user, users);

        if (result[1] == 0) {
            users.add(result[0], user);
        }

        return result[1];
    }

    // Извлечение пароля
    public static Integer getPassword(User user, List<User> users) {
        int[] result = Users_data.getInAllInfo(user, users);

        if (result[1] == 1) {
            return users.get(result[0]).password;
        }

        return null;
    }

    // Обновление пароля
    public static boolean updatePassword(User user, int newPassword, List<User> users) {
        int[] result = Users_data.getInAllInfo(user, users);

        if (result[1] == 1) {
            users.get(result[0]).password = newPassword;
            user.password = newPassword;
            return true;
        }

        return false;
    }

    // Удаление записи
    public static boolean deleteUser(User user, List<User> users) {
        int[] result = Users_data.getInAllInfo(user, users);

        if (result[1] == 1) {
            users.remove(result[0]);
            return true;
        }

        return false;
    }
}

