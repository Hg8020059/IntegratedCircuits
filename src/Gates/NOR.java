package Gates;
import Basics.*;

public class NOR extends Gates{
    public PMOS p1;
    public PMOS p2;
    public NMOS n1;
    public NMOS n2;

    public Wire W_input1;
    public Wire W_input2;
    //----------------------------------------- Constructors --------------------------------------------------
    public NOR(Wire inputWire, Wire inputWire2){
        //sets the input wire that was passed in as W_input, then uses that while declaring the Gates.PMOS and Gates.NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        W_input2 = inputWire2;

        Wire p1out = new Wire("Gates.PMOS 1 out");

        p1 = new PMOS(W_vpp, W_input1, p1out);
        p2 = new PMOS(p1out, W_input2, W_out);

        n1 = new NMOS(W_ground, W_input1, W_out);
        n2 = new NMOS(W_ground, W_input2, W_out);
    }
    //----------------------------------------- Mutators ------------------------------------------------------
    //----------------------------------------- Accessors -----------------------------------------------------


    //----------------------------------------- Testing -------------------------------------------------------
    public static void main(String[] args){
        Wire Input_Wire = new Wire("In1");
        Wire Input_Wire2 = new Wire("In2");

        Input Input1 = new Input(Input_Wire, false, "In1");
        Input Input2 = new Input(Input_Wire2, false, "In2");

        NOR nor1 = new NOR(Input_Wire, Input_Wire2);

        System.out.println(Util.truthTable(new Input[]{Input1,Input2}, nor1.W_out));
    }
}
