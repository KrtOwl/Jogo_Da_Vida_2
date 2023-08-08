package com.github.krtowl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

    /**
     * https://conwaylife.com/wiki/Blinker
     */
    @Test
    void quandoBlinkerEntaoOscila() throws Exception {
        var grade = new Grade(new Tamanho(3), new Tamanho(3));

        grade.trocarCelulaParaViva(0,1);
        grade.trocarCelulaParaViva(1,1);
        grade.trocarCelulaParaViva(2,1);

        var nova = grade.proximo();

        assertFalse(nova.isViva(0,0)); assertTrue(nova.isViva(1,0)); assertFalse(nova.isViva(2,0));
        assertFalse(nova.isViva(0,1)); assertTrue(nova.isViva(1,1)); assertFalse(nova.isViva(2,1));
        assertFalse(nova.isViva(0,2)); assertTrue(nova.isViva(1,2)); assertFalse(nova.isViva(2,2));
    }
}