import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AnimalParametrizedTest {
    public String animalKind;
    public List<String>animalFood;

    public AnimalParametrizedTest (String animalKind, List<String>animalFood) {
        this.animalFood = animalFood;
        this.animalKind = animalKind;
    }
    @Parameterized.Parameters
    public static Object [][] getParams(){
        return new Object[][] {
                {"Травоядное",List.of("Трава","Различные растения")},
                {"Хищник",List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void getFoodTest() {
        Animal animal = new Animal();
        try {
            assertEquals(animalFood,animal.getFood(animalKind));
        } catch (Exception e) {
           assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }

        }

}
