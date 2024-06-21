import com.example.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedString, animal.getFamily());
    }
    @Test
    public void getFoodThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        new Animal().getFood("");
    }
}
