import java.util.List;

public abstract class AbstractList<E> implements List<E> {
    public abstract int size();
    public boolean isEmpty(){
        return (size() == 0);
    }
    public abstract E get(int index);

    public void add(int index, E element) throws UnsupportedOperationException{

    }

    public boolean add(E element){
        try {
            add(size(), element);
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean contains(Object ob){
        for(int i=0;i<size();i++){
            if(get(i).equals(ob)) return true;
        }
        return false;
    }

    public void clear(){
        while(size()>0){
            remove(0);
        }
    }

}
