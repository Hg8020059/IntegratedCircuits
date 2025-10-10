public class NOT extends Gates{
    // Setting up internal circuitry for the not gate
    PMOS NOT_p1;
    NMOS NOT_n1;
    Wire W_input1;

    //----------------------------------------- Constructors --------------------------------------------------

    NOT(Wire inputWire){
        init(inputWire);
    }
    //----------------------------------------- Mutators ------------------------------------------------------

    void init(Wire inputWire) {
        //sets the input wire that was passed in as W_input, then uses that while declaring the PMOS and NMOS as their controls
        // Set the input before setting things that depend on the input wire
        W_input1 = inputWire;
        NOT_p1 = new PMOS(W_vpp, W_input1, W_out);
        NOT_n1 = new NMOS(W_ground, W_input1, W_out);
    }

    //----------------------------------------- Accessors -----------------------------------------------------

    //----------------------------------------- Testing -------------------------------------------------------

    public static void main(String[] args){
        Wire w_in = new Wire("NOT_In");
        Input input = new Input(w_in, true, "NOT_In");
        NOT not = new NOT(w_in);

        System.out.println(Util.truthTable(new Input[]{input}, not.W_out));
    }
}
