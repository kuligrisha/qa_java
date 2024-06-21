import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private String sex;
    private boolean hasMane;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
        @Parameterized.Parameters
        public static Object[][] getParams() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false},
            };
        }
    @Mock
    Feline feline;

    @Test
    public void doesHaveManeTest() throws Exception{
            Lion lion = new Lion(sex,feline);
            assertEquals("Гриву могут иметь только самки",hasMane,lion.doesHaveMane());
        }

    }
