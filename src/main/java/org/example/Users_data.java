package org.example;

import java.util.ArrayList;
import java.util.List;

class Users_data {
    public static int[] getInAllInfo(User user, List<User> users) {
        int mid;
        int r = users.size() - 1;
        int l = 0;
        boolean flag = false;
        int [] rezult = new int[2];

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (users.get(mid).name.compareTo(user.name) == 0) {
                if (users.get(mid).password == user.password) {
                    rezult[0] = mid;
                    rezult[1] = 1;
                    return rezult;
                } else  {
                    IO.println("Wrong password");
                    flag = true;
                }
                break;
            } else if (users.get(mid).name.compareTo(user.name) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (flag) {
            rezult[1] = -1;
        } else {
            rezult[0] = l;
            rezult[1] = 0;
        }
        return rezult;
    }
}
