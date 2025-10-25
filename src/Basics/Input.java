package Basics;

public class Input extends Basic{
    static int inputNoNameCount = 0;

    //---------------------------------------------- Constructors -------------------------------------------------

    public Input(Wire output, Boolean val){
        super(output, "Basics.Input"+ inputNoNameCount++);
        this.val = val;
    }

    public Input(Wire output, Boolean val, String name){
        super(output, name);
        this.val = val;
    }

    //---------------------------------------------- Mutators -------------------------------------------------

    public void setVal(Boolean val){
        this.val = val;
    }


    //---------------------------------------------- Accessors -------------------------------------------------

    public String toString() {
        return (super.toString() + "\nOutput Value: " + val.toString());
    }

    public Boolean getOut(){
        return val;
    }
}
