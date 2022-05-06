package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import src.UserPage;

class UserPageTest {

    @Test
    public void testCreateUserPage() {
        UserPage page = new UserPage(false);
        assertNotNull(page);
    }


}