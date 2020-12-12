package INFO6205;

import INFO6205.People;
import INFO6205.Place.Place;
import INFO6205.Place.Place1;
import INFO6205.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Place1Test {


    @Mock
    Position position;
    List<Position>positions = new ArrayList<>();
    @BeforeEach
    void setUp() {
      positions.add(position);

    }
    @Test
    public void VerifyPlaceObjectIsCreatedWhenListOfPositionIsSupplied(){
        Place place =new Place1(positions);
        assertNotNull(place);
    }


}