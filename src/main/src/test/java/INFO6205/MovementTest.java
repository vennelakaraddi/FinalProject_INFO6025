package INFO6205;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Mock
    People people;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void movementObjectisNotnull(){
        Movement movement =new Movement(people,5);
        assertNotNull(movement);
        System.out.println(movement.stay);
        System.out.println(movement.makeStay());
    }

    @Test
    public void verifyIfStayisNotFinished(){
        Movement movement =new Movement(people,5);
        assertEquals(movement.makeStay(),false);

    }


    @Test
    public void verifyIfStayisFinished(){
        Movement movement =new Movement(people,-1);
        assertEquals(movement.makeStay(),true);

    }



}