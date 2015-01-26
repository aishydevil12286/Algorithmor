package misc;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
    
    public static void main(String [] args) {
        System.out.println(ObjectSizeFetcher.getObjectSize(new C(12,15)));
    }
}

/*Add the following to your MANIFEST.MF:

Premain-Class: ObjectSizeFetcher
Use getObjectSize:*/

 class C {
    private int x ;
    private int y ;
    
    public C(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    
    public C(){
    	this.x = 0;
    	this.y = 0;
    }
}