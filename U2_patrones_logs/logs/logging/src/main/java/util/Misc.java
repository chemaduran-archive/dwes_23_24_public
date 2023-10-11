package util;

import org.apache.log4j.Logger;

public class Misc {
    final static Logger logger = Logger.getLogger(Misc.class);

    public static int addition(int op1, int op2) {
        logger.info("Entrando en addition [Misc.class]");
        int result = op1 + op2;
        logger.error("Terminando addition [Misc.class]");
        return result;
    }

    public static int substraction(int op1, int op2) {
        logger.info("Entrando en substraction [Misc.class]");
        int result = op1 - op2;
        logger.info("Saliendo de substraction [Misc.class]");
        return result;
    }
}
