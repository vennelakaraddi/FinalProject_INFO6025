package INFO6205;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SarsTest {

    @Test
    public void verifySarsObjectisNotNull(){
        Sars sars = new Sars();
        assertNotNull(sars);
    }

}