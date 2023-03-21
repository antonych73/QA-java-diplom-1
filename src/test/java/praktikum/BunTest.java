package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;
    private final String name;
    private final float price;

    public BunTest(Bun bun,
                   String name,
                   float price) {
        this.bun = bun;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Bun("black bun", 100), "black bun", 100},
                {new Bun(null, 9999.99f), null, 9999.99f},
                {new Bun("DLFKHLSFKJSDLFKSLFKJSDLFKSE", -100), "DLFKHLSFKJSDLFKSLFKJSDLFKSE", -100},
                {new Bun("black bun$$", 0.0f), "black bun$$", 0.0f},
                {new Bun("%%black bun", 0.01f), "%%black bun", 0.01f}
        };
    }


    @Test
    public void getNameTest() {
        assertEquals("'Name' is correct", name, bun.getName());
        assertNotEquals("'Name' is not correct", EMPTY, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("'Price' is correct", price, bun.getPrice(), 0);
        assertNotEquals("'Price' is not correct", price + 0.1f, bun.getPrice(), 0);
    }
}