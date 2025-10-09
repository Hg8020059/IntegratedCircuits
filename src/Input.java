public class Input extends Basic{
    static int inputNoNameCount = 0;

    //---------------------------------------------- Constructors -------------------------------------------------

    Input(Wire output, Boolean val){
        super(output, "Input"+ inputNoNameCount++);
        this.val = val;
    }

    Input(Wire output, Boolean val, String name){
        super(output, name);
        this.val = val;
    }

    //---------------------------------------------- Mutators -------------------------------------------------

    void setVal(Boolean val){
        this.val = val;
    }


    //---------------------------------------------- Accessors -------------------------------------------------

    public String toString() {
        return (super.toString() + "\nOutput Value: " + val.toString());
    }

    Boolean getOut(){
        return val;
    }
}
