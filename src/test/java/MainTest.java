import com.cleo.Main;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MainTest {

    @Test
    public void testMain(){
        Main main = new Main();
        assertEquals(main.fib(10),55);
    }
}
