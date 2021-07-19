package _70_JUnit5;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private static App app;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("avant tout les tests");
        app = new App();
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("après tout les tests");
        app = null;
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("avant chaque test");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("après chaque test");
    }

    @Test
    public void testShouldPass(){
        assertAll(
                ()->app.setB(2),
                ()->assertEquals(4, app.divide(8)),
                ()->app.setB(0),
                ()->assertThrows(Exception.class, ()->app.divide(5))
        );
    }
    @Test
    public void testShouldntPass(){
        assertAll(
                ()->app.setB(0),
                ()->assertEquals(4, app.divide(8)),
                ()->app.setB(4),
                ()->assertThrows(Exception.class, ()->app.divide(5))
        );
    }
}
