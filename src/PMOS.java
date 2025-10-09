public class PMOS extends Transistor {
    static int pmosNoNameCount = 1;

    //----------------------------------------- Constructors --------------------------------------------------

    PMOS(Wire input, Wire control, Wire output) {
        super(input, control, output, "PMOS"+ pmosNoNameCount++);
    }

    PMOS(Wire input, Wire control, Wire output, String name){
        super(input, control, output, name);
    }

    //----------------------------------------- Mutators ------------------------------------------------------

    //----------------------------------------- Accessors -----------------------------------------------------

    Boolean getOut() {
        if(control.getOut() == true){
            return false;
        }
        else if (control.getOut() == false){
            return input.getOut();
        }
        else return null;
    }
}
