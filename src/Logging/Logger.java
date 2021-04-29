package Logging;

/**
 * IDE: IntelliJ IDEA
 * File Name: Logging
 * Created by: Chad Eckles.
 * Date: 7/12/2017
 * INFO:
 */
public class Logger {

    //Characters
    public static final char ESCAPE      = 27;
    public static final String NEWLINE   = "\n\r";

    //Text Style
    public static final int NORMAL       = 0;
    public static final int BOLD         = 1;
    public static final int FAINT        = 2;
    public static final int ITALIC       = 3;
    public static final int UNDERLINE    = 4;
    public static final int BLINK        = 5;

    //Color
    public static final int BLACK        = 0;
    public static final int RED          = 1;
    public static final int GREEN        = 2;
    public static final int YELLOW       = 3;
    public static final int BLUE         = 4;
    public static final int MAGENTA      = 5;
    public static final int CYAN         = 6;
    public static final int WHITE        = 7;

    //Color Mode
    public static final int FOREGROUND   = 30;
    public static final int BACKGROUND   = 40;

    //Log
    public static final int LOG_LEVEL_ERROR     = 0;
    public static final int LOG_LEVEL_WARNING   = 1;
    public static final int LOG_LEVEL_INFO      = 3;
    public static final int LOG_LEVEL_TRACE     = 4;
    public static final int LOG_LEVEL_DEBUG     = 5;

    private static int logLevel       = LOG_LEVEL_ERROR;
    private static int traceLevel     = 0;

    private static boolean useColor   = true;

    public static void setUseColors(boolean useColor){
        Logger.useColor = useColor;
    }

    public static boolean isUseColor(){
        return useColor;
    }

    public static void setLogLevel(int logLevel){
        Logger.logLevel = logLevel;
    }

    public static int getLogLevel(){
        return logLevel;
    }

    public static void setTraceLevel(int traceLevel){
        Logger.traceLevel = traceLevel;
    }

    public static int getTraceLevel(){
        return traceLevel;
    }

    private static String getClassName(){
        return getClassName(4);
    }

    public static String getClassName(int level){
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement previous = elements[level];

        String className = previous.getClassName();
        String[] splitName = className.split("\\.");
        if(splitName.length > 0) {
            className = splitName[splitName.length  - 1];
        }
        return className;
    }

    public static void i(Object... values){
        String className = getClassName();
        String line = "";
        for(Object v : values){
            line += v;
        }
        if(logLevel >= LOG_LEVEL_INFO){
            print("[",NORMAL);
            print("INFO",BOLD,WHITE);
            print("]",NORMAL);
            print("[",NORMAL);
            print(className,ITALIC, WHITE);
            print("] ",NORMAL);
            print(line,NORMAL,WHITE);
            endPrint();
        }
    }

    public static void t(int level, Object... values){
        String className = getClassName();
        String methodName = getMethod();
        String lineNumber = getLineNumber();

        String line = "";
        for(Object v : values){
            line += v;
        }
        //if(logLevel >= LOG_LEVEL_TRACE && level <= traceLevel){
        if(logLevel >= LOG_LEVEL_TRACE){
            print("[",NORMAL);
            print("TRACE",BOLD,MAGENTA);
            print("]",NORMAL);

            print("[",NORMAL);
            print(""+ level,BOLD,MAGENTA);
            print("]",NORMAL);

            print("[",NORMAL);
            print(className,ITALIC, MAGENTA);
            print("]",NORMAL);

            print("[",NORMAL);
            print(methodName,FAINT, MAGENTA);
            print("]",NORMAL);

            print("[",NORMAL);
            print(lineNumber,ITALIC, MAGENTA);
            print("] ",NORMAL);

            print(line,UNDERLINE,MAGENTA);
            endPrint();
        }
    }

    public static void w(Object... values){
        String className = getClassName();
        String methodName = getMethod();

        String line = "";
        for(Object v : values){
            line += v;
        }
        if(logLevel >= LOG_LEVEL_WARNING){
            print("[",NORMAL);
            print("WARNING",BOLD,YELLOW);
            print("]",NORMAL);

            print("[",NORMAL);
            print(className,ITALIC, YELLOW);
            print("]",NORMAL);

            print("[",NORMAL);
            print(methodName,FAINT, YELLOW);
            print("] ",NORMAL);

            print(line,FAINT,YELLOW);
            endPrint();
        }
    }
    public static void d(Object... values){
        String className = getClassName();
        String methodName = getMethod();
        String lineNumber = getLineNumber();

        //String line = "\r\n";
        String line = "";
        for(Object v : values){
            line += v;
            //line += v + "("+ v.getClass() +")\r\n";
        }
        if(logLevel >= LOG_LEVEL_DEBUG){
            print("[",NORMAL);
            print("DEBUG",BOLD,BLUE);
            print("]",NORMAL);

            print("[",NORMAL);
            print(className,ITALIC, BLUE);
            print("]",NORMAL);

            print("[",NORMAL);
            print(methodName,FAINT, BLUE);
            print("]",NORMAL);

            print("[",NORMAL);
            print(lineNumber,ITALIC, BLUE);
            print("] ",NORMAL);

            print(line,BOLD,BLUE, WHITE);
            endPrint();
        }
    }
    public static void e(Object... values){
        String className = getClassName();
        String methodName = getMethod();
        String lineNumber = getLineNumber();

        String line = "";
        for(Object v : values){
            line += v;
        }
        if(logLevel >= LOG_LEVEL_ERROR){
            print("[",NORMAL);
            print("ERROR",BOLD,RED);
            print("]",NORMAL);

            print("[",NORMAL);
            print(className,ITALIC, RED);
            print("]",NORMAL);

            print("[",NORMAL);
            print(methodName,FAINT, RED);
            print("]",NORMAL);

            print("[",NORMAL);
            print(lineNumber,ITALIC, RED);
            print("] ",NORMAL);

            print(line,BOLD,RED);
            endPrint();
        }
    }

    private static String getMethod(){
        return getMethod(4);
    }

    public static String getMethod(int level){
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement previous = elements[level];

        return previous.getMethodName();
    }

    private static String getLineNumber(){
        return getLineNumber(4);
    }

    public static String getLineNumber(int level){
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement previous = elements[level];

        return "" + previous.getLineNumber();
    }

    public static void print(String data){
        if(useColor){
            System.out.printf("%c[0m%s", ESCAPE, data);
        }
        else {
            printNormal(data);
        }
    }

    public static void print(String data,int style){
        if(useColor){
            System.out.printf("%c[%dm%s", ESCAPE, style,data);
        }
        else {
            printNormal(data);
        }
    }

    public static void print(String data,int style, int forground){
        if(useColor){
            System.out.printf("%c[%d;%dm%s", ESCAPE, style, FOREGROUND + forground, data);
        }
        else {
            printNormal(data);
        }
    }

    public static void print(String data,int style, int forground, int background){
        if(useColor){
            System.out.printf("%c[%d;%d;%dm%s", ESCAPE, style, FOREGROUND + forground,BACKGROUND + background, data);
        }
        else {
            printNormal(data);
        }
    }

    public static void endPrint(){
        if(useColor){
            System.out.printf("%c[0m%s",ESCAPE,NEWLINE);
        }
        else{
            printNormal(NEWLINE);
        }
    }

    private static void printNormal(String data){
        System.out.printf("%s",data);
    }
}
/*
        Logging.setLogLevel(Logging.LOG_LEVEL_DEBUG);

                Logging.i("Hello World!");

                Logging.t(0,"Testing trace level 0");
                Logging.t(9,"Testing trace level 9");
                Logging.t(10,"Testing trace level 10");
                Logging.t(12,"Testing trace level 12");

                Logging.w("This is a warning!");

                Logging.e("This is an Error!");

                Logging.d("Debugging values ",20F,10L,15D,0.0,(char)32,System.out);

                Logging.print("Print Method from Logging", Logging.BLINK,Logging.GREEN,Logging.WHITE);
                Logging.endPrint();

*/