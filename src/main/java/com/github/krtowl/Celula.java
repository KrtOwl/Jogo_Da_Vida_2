package com.github.krtowl;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Celula {

    public void printVivo(){
        System.out.print(colorize(" ", GREEN_BACK()));
    }

    public void printMorto(){
        System.out.print(colorize(" ", BLACK_BACK()));
    }

}
