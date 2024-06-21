import com.example.Feline;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FelineTest {
    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline();
        assertThat(feline.eatMeat(),
                equalTo(feline.getFood("Хищник")));
    }

    @Test
    public void getFamilyReturnIsCorrect() {
        String expectedFelineFamilyReturn = "Кошачьи";

        assertThat("Это животное не принадлежит к семейству кошачьих",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyReturn));
    }

    @Test
    public void getKittensCountIsCorrect() {
        int expectedCountOfKittens = 7;
        assertThat("Неверное количество котят",
                new Feline().getKittens(expectedCountOfKittens),
                equalTo(expectedCountOfKittens));

    }

    @Test
    public void getKittensIsDefaultValue() {
        int expectedCountOfKittens = 1;
        assertThat("Неверное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCountOfKittens));
    }

}
