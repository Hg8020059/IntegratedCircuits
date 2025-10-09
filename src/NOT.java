public class NOT extends Gates{
    // Setting up internal circuitry for the not gate
    PMOS NOT_p1;
    NMOS NOT_n1;
    Wire W_input1;

    //----------------------------------------- Constructors --------------------------------------------------

    NOT(Wire inputWire){
        //sets the input wire that was passed in as W_input, then uses that while declaring the PMOS and NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        NOT_p1 = new PMOS(W_vpp, W_input1, W_out);
        NOT_n1 = new NMOS(W_ground, W_input1, W_out);
    }
    //----------------------------------------- Mutators ------------------------------------------------------

    //----------------------------------------- Accessors -----------------------------------------------------

//    static String truthTable() {
//        //String str = Gates.truthTable();
//        String str = "";
//        str += "x | out\n" +
//                "--|----\n";
//
//        //Actually generate the truth table each time for testing/ensuring the code works
//        Wire NOT_Input_Wire = new Wire("NOT_In");
//        Input NOT_Input = new Input(NOT_Input_Wire, true, "NOT_In");
//        NOT not1 = new NOT(NOT_Input_Wire);
//
//        str += Util.toInt(NOT_Input_Wire.getOut()) + " | "+ Util.toInt(not1.getOut()) + "\n";
//        NOT_Input.setVal(false);
//        str += Util.toInt(NOT_Input_Wire.getOut()) + " | "+ Util.toInt(not1.getOut()) + "\n";
//
//        return str;
//    }


    //----------------------------------------- Testing -------------------------------------------------------

    public static void main(String[] args){
        Wire NOT_Input_Wire = new Wire("NOT_In");
        Input NOT_Input = new Input(NOT_Input_Wire, true, "NOT_In");
        NOT not1 = new NOT(NOT_Input_Wire);

        System.out.println("Input: " + NOT_Input_Wire.getOut() + ", Result: "+ not1.getOut());
        NOT_Input.setVal(false);
        System.out.println("Input: " + NOT_Input_Wire.getOut() + ", Result: "+ not1.getOut());

        //System.out.println(NOT.truthTable());
    }
}
