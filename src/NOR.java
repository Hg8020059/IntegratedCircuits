public class NOR extends Gates{
    PMOS p1;
    PMOS p2;
    NMOS n1;
    NMOS n2;

    Wire W_input1;
    Wire W_input2;
    //----------------------------------------- Constructors --------------------------------------------------
    NOR(Wire inputWire, Wire inputWire2){
        //sets the input wire that was passed in as W_input, then uses that while declaring the PMOS and NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        W_input2 = inputWire2;

        Wire p1out = new Wire("PMOS 1 out");

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

        System.out.println(nor1.W_out);

        System.out.println("Inputs: " + Input_Wire.getOut() + ", " + Input_Wire2.getOut() + ", Result: "+ nor1.getOut());
        Input2.setVal(true);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ nor1.getOut());
        Input1.setVal(true);
        Input2.setVal(false);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ nor1.getOut());
        Input1.setVal(true);
        Input2.setVal(true);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ nor1.getOut());
    }
}
