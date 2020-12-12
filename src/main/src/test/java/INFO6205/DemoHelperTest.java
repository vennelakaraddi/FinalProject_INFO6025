package INFO6205;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class DemoHelperTest {
    @Mock
    Canvas canvas;

    @BeforeEach
    void setUp() {

    }
    @Test
    public void DemoHelperObjectIsNotNull(){
        DemoHelper demoHelper =new DemoHelper(canvas);
        assertNotNull(demoHelper);
    }

}