package test.java;
import static org.junit.Assert.assertTrue;

/*

 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import main.java.*;


public class CardTest {
    /*@Test 
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }*/
	@Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    @Test
	public void testDealAll(){
    	//assertEquals(1+1,3);
    	CardDeck A = new CardDeck();
    	assertTrue(Helper.dealAll(A));
	}
    @Test
    public void testShuffleThenDealAll(){
    	CardDeck A = new CardDeck();
    	A.shuffle();
    	assertTrue(Helper.dealAll(A));
    }
    @Test
    public void testDealOneCardThenDeallAll(){
    	CardDeck A = new CardDeck();
    	A.shuffle();
    	A.dealOneCard();
    	assertTrue(Helper.dealAll(A));
    }
    @Test
    public void testDealOneCardThenShuffle(){
    	CardDeck A = new CardDeck();
    	A.shuffle();
    	A.dealOneCard();
    	A.shuffle();
    	assertTrue(Helper.dealAll(A));
    }
}

