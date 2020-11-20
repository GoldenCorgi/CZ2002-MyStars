package mystars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @Test
    void loadCourses() {
        assertTrue(true);
    }

    @Test
    void saveCourses() {
        assertTrue(true);
    }

    @Test
    void loadStudents() {
        assert(Storage.loadStudents() != null);
        assertTrue(true);
    }

    @Test
    void saveStudents() {
        assertTrue(true);
    }

    @Test
    void loadUsers() {
        assert(Storage.loadUsers() != null);
        assertTrue(true);
    }

    @Test
    void saveUsers() {
        assertTrue(true);
    }
}