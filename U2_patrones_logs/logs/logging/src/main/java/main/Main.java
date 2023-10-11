package main;


import org.apache.log4j.Logger;
import util.Misc;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args){

        logger.info("Antes de la invocación. En [Main.class]");

        int result = Misc.addition(5, 7);
        result = Misc.substraction(result, 3);

        logger.info("Después de la invocación. En [Main.class]");

    }
}
