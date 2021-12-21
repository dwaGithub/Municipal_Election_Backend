package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestControllerTest {

    @Test
    void hello() {
        TestController controller = new TestController();
        String response = controller.hello("World");
        assertEquals("Hello", response);
    }
}