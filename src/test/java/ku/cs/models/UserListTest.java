package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList userList = new UserList();
        userList.addUser("user1", "student1");
        userList.addUser("user2", "student2");
        userList.addUser("user3", "student3");

        User user = userList.findUserByUsername("user3");

        assertNotNull(user, "User should be found");
        assertEquals("user3", user.getUsername(), "Username should match");
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        UserList userList = new UserList();
        userList.addUser("user1", "student1");
        userList.addUser("user2", "student2");
        userList.addUser("user3", "student3");

        boolean isPasswordChanged = userList.changePassword("user1", "student1", "newPassword");

        assertTrue(isPasswordChanged, "Password should be changed successfully");

        User user = userList.findUserByUsername("user1");
        assertNotNull(user, "User should be found after password change");
        assertEquals("newPassword", user.getPassword(), "Password should be updated");
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "student1");
        userList.addUser("user2", "student2");
        userList.addUser("user3", "student3");

        User user = userList.login("user1", "student1");

        assertNotNull(user, "User should be logged in successfully");
        assertEquals("user1", user.getUsername(), "Username should match");
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "student1");
        userList.addUser("user2", "student2");
        userList.addUser("user3", "student3");

        User user = userList.login("user1", "wrongPassword");

        assertNull(user, "Login should fail with incorrect password");
    }
}
