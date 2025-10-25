package Gates;
import Basics.*;

public class NAND extends Gates{
    public static int numInputs = 2;

    public PMOS p1;
    public PMOS p2;
    public NMOS n1;
    public NMOS n2;

    public Wire W_input1;
    public Wire W_input2;
    //----------------------------------------- Constructors --------------------------------------------------

    NAND(){
        PMOS p1 = null;
        PMOS p2 = null;
        NMOS n1 = null;
        NMOS n2 = null;

        Wire W_input1 = null;
        Wire W_input2 = null;
    }

    NAND(Wire inputWire, Wire inputWire2){
        init(inputWire, inputWire2);
    }
    //----------------------------------------- Mutators ------------------------------------------------------

    void init(Wire inputWire, Wire inputWire2){
        //sets the input wire that was passed in as W_input, then uses that while declaring the Gates.PMOS and Gates.NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        W_input2 = inputWire2;

        p1 = new PMOS(W_vpp, W_input1, W_out);
        p2 = new PMOS(W_vpp, W_input2, W_out);

        Wire n1out = new Wire("Gates.NMOS 1 out");

        n1 = new NMOS(W_ground, W_input1, n1out);
        n2 = new NMOS(n1out, W_input2, W_out);
    }

    //----------------------------------------- Accessors -----------------------------------------------------


    //----------------------------------------- Testing -------------------------------------------------------
    public static void main(String[] args){
        Wire w_in1 = new Wire();
        Wire w_in2 = new Wire();
        NAND nand = new NAND(w_in1,w_in2);
        Input Input1 = new Input(w_in1, false);
        Input Input2 = new Input(w_in2, false);

        Util.truthTable(new Input[]{Input1,Input2}, nand.W_out);
    }
}
