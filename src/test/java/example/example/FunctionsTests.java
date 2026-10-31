
package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    void testSaveUser() {
        List<User> users = new ArrayList<>();

        User user = new User();
        user.name = "Viktor";
        user.password = 1234;

        int result = Functions.saveOrCreateUser(user, users);

        assertEquals(0, result);
        assertEquals(1, users.size());
        assertEquals("Viktor", users.get(0).name);
    }
}
