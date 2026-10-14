
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testAddition() {
        assertEquals(5, App.add(2, 3));
    }

    @Test
    void testAdditionWithNegativeNumbers() {
        assertEquals(0, App.add(-2, 2));
    }
}
