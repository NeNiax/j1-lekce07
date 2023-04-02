package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
        assertNull(svatky.kdyMaSvatek("kdoweiuro1"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //testuju, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Alex"));
        assertFalse(svatky.jeVSeznamu("Peti"));
        assertFalse(svatky.jeVSeznamu("42"));
        assertFalse(svatky.jeVSeznamu("lkdfjoeiu"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //Otestuji, že vrací počet jmen v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        assertNotEquals(42, svatky.getPocetJmen());
        assertNotEquals(0, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        // Testuji, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
        assertNotNull(svatky.getSeznamJmen());
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //Testuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Pokus", 15, 10);
        assertTrue(svatky.jeVSeznamu("Pokus"));
        assertEquals(MonthDay.of(10, 15), svatky.kdyMaSvatek("Pokus"));
        svatky.smazatSvatek("Pokus");
        assertFalse(svatky.jeVSeznamu("Pokus"));

    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //Testuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Pokus", 15, Month.OCTOBER);
        assertTrue(svatky.jeVSeznamu("Pokus"));
        assertEquals(MonthDay.of(10, 15), svatky.kdyMaSvatek("Pokus"));
        svatky.smazatSvatek("Pokus");
        assertFalse(svatky.jeVSeznamu("Pokus"));
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void pridatSvatekMonthDay() {
        //Testuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Pokus", MonthDay.of(10, 15));
        assertTrue(svatky.jeVSeznamu("Pokus"));
        assertEquals(MonthDay.of(10, 15), svatky.kdyMaSvatek("Pokus"));
        svatky.smazatSvatek("Pokus");
        assertFalse(svatky.jeVSeznamu("Pokus"));
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //Testuje, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Pokus", 10, 10);
        int vysledek = svatky.getPocetJmen();
        svatky.smazatSvatek("Pokus");
        assertEquals(vysledek - 1, svatky.getPocetJmen());
        assertNotEquals(vysledek, svatky.getPocetJmen());
        assertFalse(svatky.jeVSeznamu("Pokus"));
    }
}
