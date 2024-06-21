import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.rules.ExpectedException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class LionTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", feline);
        assertThat("Количество котят несоотвествует действительному",lion.getKittens(), equalTo(5));
    }
    @Test
    public void lionGetFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы","Рыба"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы","Рыба"), lion.getFood());
    }
    @Test
    public void createLionThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самец или самка");

        new Lion("Не определено", feline);
    }
   }
