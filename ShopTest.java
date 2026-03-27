import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {
    /**
     * Bug 1: price as 0 instead of using price parameter.
     */
    @Test
    public void testComputerPriceConstructor() {
        Computer c = new Computer("Test", "Intel", 256, 16, "macOS", 2020, 800);
        assertEquals("Price should be 800 (passed value), not hardcoded 0", 800, c.price);
    }
    /**
     * Bug 2: hardcodes memory as 16 instead of using memory parameter.
     */
    @Test
    public void testComputerMemoryConstructor() {
        Computer c = new Computer("Test", "Intel", 256, 32, "macOS", 2020, 500);
        assertEquals("Memory should be 32 (passed value), not hardcoded 16", 32, c.memory);
    }

    /**
     * Bug 3: setOS() always sets operatingSystem to none instead of newOS.
     */
    @Test
    public void testSetOS() {
        Computer c = new Computer("Test", "Intel", 256, 16, "High Sierra", 2019, 1000);
        c.setOS("Ventura");
        assertEquals("setOS should update OS to 'Ventura'", "Ventura", c.operatingSystem);
    }
    /**
     * Bug 4: buy() does not throw a RuntimeException for duplicates.
     */
    @Test(expected = RuntimeException.class)
    public void testBuyDuplicateThrows() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2020 MacBook Air", "M1", 256, 8, "Big Sur", 2020, 900);
        shop.buy(c);
        shop.buy(c); // second add should throw
    }

    /**
     * Bug 5: printInventory() uses <= instead of <
     */
    @Test
    public void testPrintInventoryNoException() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2021 MacBook Pro", "M1 Pro", 512, 16, "Monterey", 2021, 1500);
        shop.buy(c);
        // Should not throw any exception
        shop.printInventory();
    }

    /**
     * Bug 6: sell() does not throw a RuntimeException when asked to sell a computer that is not in inventory.
     */
    @Test(expected = RuntimeException.class)
    public void testSellNotInInventoryThrows() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2018 Lenovo", "Intel", 256, 8, "Windows 11", 2018, 300);
        shop.sell(c); // not in inventory — should throw
    }

    /**
     * Bug 7: refurbish() uses != for String comparison instead of
     * .equals(), so setOS() is never called when a new OS is provided.
     */
    @Test
    public void testRefurbishUpdatesOS() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(c);
        shop.refurbish(c, "Ventura");
        assertEquals("refurbish() should update OS when newOS != \"None\"",
                     "Ventura", c.operatingSystem);
    }

    /**
     * Bug 8: refurbish() sets price to 2500 for computers made between
     * refurbish() sets price to 2500 for 2000–2011 computers. This doesn't follow the pattern of price being higher than newer computers.
     */
    @Test
    public void testRefurbishPrice2000to2011() {
        ResaleShop shop = new ResaleShop();
        Computer old = new Computer("2005 ThinkPad", "Intel", 80, 2, "Windows XP", 2005, 50);
        shop.buy(old);
        shop.refurbish(old, "None");
        assertTrue("A 2005 computer should be priced less than a 2019 computer after refurbish", old.price < 1000);
    }

    /** 
     * Bug 9: alreadyInInventory() does not properly check if a computer is already in inventory. 
     * This test should verify that trying to buy a computer that is already in inventory throws a RuntimeException.
    */
    @Test
    public void alreadyInInventory(){
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2020 MacBook Air", "M1", 256, 8, "Big Sur", 2020, 900);
        shop.buy(c);
        try {
            shop.buy(c); // Attempt to buy the same computer again
            fail("Expected RuntimeException when buying a duplicate computer");
        } catch (RuntimeException e) {
            // Expected exception was thrown
        }


    }
    /**
     * Bug 10: refurbish() does not check if the computer is in inventory before trying to refurbish it. This test should verify that trying to refurbish a computer that is not in inventory throws a RuntimeException.
     * This test should verify that trying to refurbish a computer that is not in inventory throws a RuntimeException.
     */
    @Test
    public void testRefurbishDoesNotChangeOSWhenNewOSIsNone() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2018 Lenovo", "Intel", 256, 8, "Windows 11", 2018, 300);
        shop.buy(c);

        shop.refurbish(c, new String("None"));

        assertEquals("Windows 11", c.operatingSystem);
}
    }