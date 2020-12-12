package INFO6205;

import INFO6205.People;
import INFO6205.Place.Place;
import INFO6205.Place.Place1;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {
    @Mock
    public Place home;
    @Mock
    public Place publicPlace;
    @Mock
    People mockPeople;

    @Test
    public void VerifyAgeisLessThan100(){
       People people = new People();
        int a =people.returnAge();
        assertTrue(a<100);


    }
    @Test
    public void verifyPeopleObjectIsNotNull(){
        People people = new People();
        assertNotNull(people);

    }

}