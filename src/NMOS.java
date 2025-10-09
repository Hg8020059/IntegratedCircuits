public class NMOS extends Transistor{
    static int nmosNoNameCount = 1;

    //----------------------------------------- Constructors --------------------------------------------------

    NMOS(Wire input, Wire control, Wire output) {
        super(input, control, output, "NMOS"+ nmosNoNameCount++);
    }

    NMOS(Wire input, Wire control, Wire output, String name){
        super(input, control, output, name);
    }

    //----------------------------------------- Mutators ------------------------------------------------------

    //----------------------------------------- Accessors -----------------------------------------------------


    Boolean getOut() {
        if(control.getOut() == false){
            return false;
        }
        else if (control.getOut() == true){
            return input.getOut();
        }
        else return null;
    }
}
