package Back;

public class DetailsForFixing {
    
     public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }
    
    private String type;
    private int count;
    
    DetailsForFixing (String type, int count){
        this.type = type;
        this.count = count;
    }
    
}
