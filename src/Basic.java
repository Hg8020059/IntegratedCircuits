//Basic should be what's used as the V++, and ground values, as it has an unchangeable output value,
// and no input or control values
public abstract class Basic {
    static int basicNoNameCount = 1;

    String name;
    Boolean val = null;    //Output value, can only change val in Input type variables
    Wire output;    //Wire that the output of this node is connected to

    //---------------------------------------------- Constructors -------------------------------------------------
    public Basic(Wire output){
        setOutput(output);
        this.name = "Basic"+ basicNoNameCount++;
    }

    public Basic(Wire output, String name){
        setOutput(output);
        this.name = name;
    }

    //---------------------------------------------- Mutators -------------------------------------------------

    public void setOutput(Wire output){
        this.output = output;
        output.addInput(this);
    }


    //---------------------------------------------- Accessors -------------------------------------------------

    public String toString(){
        return( "Name: " + name);
    }


    abstract Boolean getOut();
}
