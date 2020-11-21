package mystars;

import mystars.login.UserList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @Test
    void loadCourses() {
        assert(Storage.loadCourses() != null);

        assertTrue(true);
    }

    @Test
    void saveCourses() {
        Storage.saveCourses(null);assertTrue(true);
    }

    @Test
    void loadStudents() {
        assert(Storage.loadStudents() != null);
        assertTrue(true);
    }

    @Test
    void saveStudents() {
        Storage.saveStudents(null);assertTrue(true);
    }

    @Test
    void loadUsers() {
        assert(Storage.loadUsers() != null);
        assertTrue(true);
    }

    @Test
    void saveUsers() throws StarsException {
        Storage.saveUsers(new UserList());assertTrue(true);
    }
}