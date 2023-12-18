package Back;

public class Shoes {
    
        public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int[] getSize() {
        return size;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
    
    public void setOneCount(int count, int i) {
        this.count[i] += count;
    }

    public double getPrice() {
        return price;
    }

//    public void setPrice(double price) {
//        this.price = price;
//    }
    
    private String type;
    private static final int[] size = new int[]{35, 36, 37, 38, 39, 40, 41};
    private int [] count = new int[size.length];
    private final double price;
  
    Shoes(String type, double price){
        for (int i=0; i<count.length; i++){
            count[i]=0;
        }
        this.type = type;
        this.price = price;
    }
    
    Shoes(String type, double price, int count){
        for (int i=0; i<this.count.length; i++){
            this.count[i]=count;
        }
        this.type = type;
        this.price = price;
    }
    
}
