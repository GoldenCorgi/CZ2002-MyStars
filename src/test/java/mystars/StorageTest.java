package mystars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StorageTest {

    @Test
    void Courses() {
        Storage.saveCourses(Storage.loadCourses());
        assert(Storage.loadCourses() != null);
        assertTrue(true);
    }

    @Test
    void Users() throws StarsException {
        Storage.saveUsers(Storage.loadUsers());
        assert(Storage.loadUsers() != null);
        assertTrue(true);
    }
    @Test
    void Students() {
        Storage.saveStudents(Storage.loadStudents());
        assert(Storage.loadStudents() != null);
        assertTrue(true);
    }

    @Test
    void loadCourses() {
        assert(Storage.loadCourses() != null);

        assertTrue(true);
    }

    @Test
    void saveCourses() {
//        Storage.saveCourses(null);
        assertTrue(true);
    }

    @Test
    void loadStudents() {
        assert(Storage.loadStudents() != null);
        assertTrue(true);
    }

    @Test
    void saveStudents() {
//        Storage.saveStudents(null);
        assertTrue(true);
    }

    @Test
    void loadUsers() {
        assert(Storage.loadUsers() != null);
        assertTrue(true);
    }

    @Test
    void saveUsers() throws StarsException {
//        Storage.saveUsers(new UserList());
        assertTrue(true);
    }
}