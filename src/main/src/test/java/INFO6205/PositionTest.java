package INFO6205;

import INFO6205.Place.Place1;
import INFO6205.Place.Place2;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Mock
    Place1 place1;
    @Mock
    Place2 place2;

    @Test
    public void verifyGetEucladianDistanceIsRetruningExpected(){
        int a =Position.getEucladianDistance(4,6,4,6);
        assertEquals(a,2);
    }

    @Test
    public void verifyPositionIsNotNull(){
        Position position =new Position(1,2);
        assertNotNull(position);

    }


}