package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApdexTest {
    private int amostras;;
    private Apdex apdex;

    @BeforeEach
    void setUp(){
        amostras = 559221;
        apdex = new Apdex();
    }

    @Test
    void testApdexCalc(){
        var result = apdex.calcApdex(490000, 60000, amostras);
        assertEquals(0.93f, result, 0.01f);
    }

    @Test
    void testApdexNull(){
        assertThrows(NullPointerException.class, () ->{
            apdex.calcApdex(null, null,null);
        });
    }

    @Test
    void testCheckApdexNull(){
        assertThrows(NullPointerException.class, () -> {
            apdex.checkApdex(null);
        });
    }
    @Test
    void testApdexExcelente(){
        var result = apdex.calcApdex(500000, 60000, amostras);
        var apdexCheckResult = apdex.checkApdex(result);
        assertEquals("Excelente", apdexCheckResult);
    }

    @Test
    void testApdexBom(){
        var result = apdex.calcApdex(490000, 60000, amostras);
        var apdexCheckResult = apdex.checkApdex(result);
        assertEquals("Bom", apdexCheckResult);
    }
    @Test
    void testApdexRazoavel(){
        var result = apdex.calcApdex(400000, 5000, amostras);
        var apdexCheckResult = apdex.checkApdex(result);
        assertEquals("Razoavel", apdexCheckResult);
    }
    @Test
    void testApdexInaceitavel(){
        var result = apdex.calcApdex(220000, 100000, amostras);
        var apdexCheckResult = apdex.checkApdex(result);
        assertEquals("Inaceitavel", apdexCheckResult);
    }
}