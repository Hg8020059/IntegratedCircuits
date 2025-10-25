/*
This class should only be used for connecting transistors to one another, as any other logic should be done with
gates, which should never input to the same wire without a gate to first combine their signals. I should make either
a separate wire class for gates, or just imply wires by directly connecting the output of one gate to another (I
prefer this solution) Can probably reuse some logic from this class to get gate input arrays working though.
*/

import java.util.ArrayList;

public class Wire {
    ArrayList<Basic> inputs;
    ArrayList<Transistor> outputs = new ArrayList<>();
    String name;
    static int wireNoNameCount = 0;

    //----------------------------------------- Constructors -----------------------------------------------------

    public Wire(){
        inputs = new ArrayList<>();
        name = "Wire" + wireNoNameCount++;
    }

    public Wire(String name){
        inputs = new ArrayList<>();
        this.name = name;
    }

    //----------------------------------------- Mutators -----------------------------------------------------

    public void addInput(Basic input){
        this.inputs.add(input); // We want to reference the original, not create a copy of it
    }

    public void addOutput(Transistor output){
        this.outputs.add(output); // We want to reference the original, not create a copy of it
    }


    public Boolean getOut(){
        Boolean out = null;
        for (Basic i : inputs){
            if (i.getOut()){
                out = true;
                return out;
            }
            out = false;
        }
        return out;
    }

    //----------------------------------------- Accessors -----------------------------------------------------

    public String toString(){
        String output = "Wire Name: " + name + "\n" + "Inputs:";
        for (Basic item : inputs) {
            output = output.concat(item.name + ", ");
        }

        output = output + "\nOutputs: ";
        for (Basic item : outputs) {
            output = output.concat(item.name + ", ");
        }

        output += "\n";

        return output;
    }

    //----------------------------------------- Testing -------------------------------------------------------
    public static void main(String[] args){
        Wire testWire = new Wire();
        Input Vpp = new Input(testWire, true, "Vpp");
        Input Ground = new Input(testWire, false, "Ground");

        System.out.println(testWire);

        // Testing wire.getOut
        System.out.println("Wire Output: " + testWire.getOut());
    }
}
