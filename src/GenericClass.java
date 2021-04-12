/*
public class GenericClass {
    public <AnyType> AnyType
    public static void main(String[] args){

    }
}

class Input<T>{
    private T a, b, c;

    //use default constructor
    //no initialization
    //values are set by users
    //no toString

    public T getA(){
        return this.a;
    }

    public T getB(){
        return this.b;
    }

    public T getC(){
        return this.c;
    }

    public void setA(T a){
        this.a = a;
    }

    public void setB(T b){
        this.b = b;
    }

    public void setC(T c){
        this.c = c;
    }

    public String toString(){
        return "a:" + a.toString() +"b:" + b.toString()+"c:" + c.toString();
    }

    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(this.getClass()!=other.getClass()){
            return false;
        }
        final Input Other = (Input) other;
        if(this.a!=Other.a){
            return false;
        }
        if(this.b!=Other.b){
            return false;
        }if(this.c!=Other.c){
            return false;
        }
        return true;
    }
}
*/