package model.base;

import java.io.File;

public class OsName {

    public final static int WINDOWS = 1;
    public final static int MACOS = 2;
    public final static int OTHEROS = 3;

    final static String UNIX_NULL_DEV = "/dev/null";

    public static int getSystem() {
        if (new File(UNIX_NULL_DEV).exists()) {
            return MACOS;
        }
        String sys = System.getProperty("os.name");
        if (sys.startsWith("Windows")) {
            return WINDOWS;
        }
        return  OTHEROS;
    }


}