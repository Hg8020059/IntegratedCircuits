// Should work on getting all toStrings to look good at some point

public class Main {
    public static void main(String[] args) {
        // Wire Testing
        System.out.println("--------- Wire Testing ---------");
        Wire.main(args);

        // Transistor Testing
        System.out.println("--------- Transistor Testing ---------");
        Transistor.main(args);

        // Not Gate Testing
        System.out.println("--------- Not Testing ---------");
        NOT.main(args);
    }
}