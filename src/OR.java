public class OR extends Gates{
    NOR nor;
    NOT not;
    Wire W_input1;
    Wire W_input2;

    OR(Wire inputWire, Wire inputWire2){
        //sets the input wire that was passed in as W_input, then uses that while declaring the PMOS and NMOS as their controls
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

        System.out.println(or1.nor.W_out);
        System.out.println(or1.not.W_out);
        System.out.println(or1.W_out);

        System.out.println("Inputs: " + Input_Wire.getOut() + ", " + Input_Wire2.getOut() + ", Result: "+ or1.getOut());
        Input2.setVal(true);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ or1.getOut());
        Input1.setVal(true);
        Input2.setVal(false);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ or1.getOut());
        Input1.setVal(true);
        Input2.setVal(true);
        System.out.println("Inputs: " + Input_Wire.getOut()+ ", "  + Input_Wire2.getOut() + ", Result: "+ or1.getOut());
    }
}
