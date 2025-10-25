package Gates;
import Basics.*;

public class OR extends Gates{
    public NOR nor;
    public NOT not;
    public Wire W_input1;
    public Wire W_input2;

    public OR(Wire inputWire, Wire inputWire2){
        //sets the input wire that was passed in as W_input, then uses that while declaring the Gates.PMOS and Gates.NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        W_input2 = inputWire2;

        nor = new NOR(inputWire, inputWire2);
        not = new NOT(nor.W_out);
        W_out = not.W_out;
    }

    public static void main(String[] args){
        Wire Input_Wire = new Wire("In1");
        Wire Input_Wire2 = new Wire("In2");

        Input Input1 = new Input(Input_Wire, false, "In1");
        Input Input2 = new Input(Input_Wire2, false, "In2");

        OR or1 = new OR(Input_Wire, Input_Wire2);

        System.out.println(Util.truthTable(new Input[]{Input1,Input2}, or1.W_out));
    }
}
