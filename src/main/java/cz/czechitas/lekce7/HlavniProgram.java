package cz.czechitas.lekce7;

import java.time.Month;
import java.time.MonthDay;

/**
 * Hlaví třída pro lekci 7.
 */
public class HlavniProgram {

    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String... args) {
        Svatky svatky = new Svatky();

        System.out.printf("V seznamu je %d jmen.", svatky.getPocetJmen()).println();
        System.out.printf("Monika má svátek %s.", svatky.kdyMaSvatek("Monika")).println();
        System.out.printf("Eva je v seznamu svátků: %b.", svatky.jeVSeznamu("Eva")).println();


        System.out.println("V seznamu jsou následující jména:");
        svatky.getSeznamJmen().forEach(jmeno -> System.out.printf("- %s", jmeno).println());

        svatky.smazatSvatek("Přemysl");
        System.out.printf("Po smazání Přemysla je v seznamu je %d jmen.", svatky.getPocetJmen()).println();

        /*
        //jak naprogramovat "leden", "unor" jako měsice:
        Month leden = Month.JANUARY;
        Month unor = Month.of(2);

        MonthDay.of(2,2);
        MonthDay.of(Month.JANUARY, 2);
        */




        svatky.pridatSvatek("Laura", 1, 6);
        svatky.pridatSvatek("Jarmil", 2, Month.JUNE);
        svatky.pridatSvatek("Tamara", MonthDay.of(6, 3));
        svatky.pridatSvatek("Kevin", MonthDay.of(Month.JUNE, 3));
        System.out.printf("Po přidání Laury, Jarmila, Tamary a Kevina je v seznamu je %d jmen.", svatky.getPocetJmen()).println();

    }

}
