package org.example;

import java.util.ArrayList;
import java.util.List;

class Users_data {
    static List<User> users = new ArrayList<>();
    public static boolean wrightin(User user) {
        int mid;
        int r = users.size() - 1;
        int l = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (users.get(mid).name.compareTo( user.name ) == 0 ) {
                return true;
            }
            else if (users.get(mid).name.compareTo( user.name ) < 0){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        users.add(l, user);
        return true;
    }
}
