package Back;

public class Fixing {
    
        public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getNeedsDetails() {
        return needsDetails;
    }
    
    private String type;
    private double price;
    private String needsDetails;
    
    Fixing(String type, double price, String needsDetails){
        this.type = type;
        this.price = price;
        this.needsDetails = needsDetails;
    }
    
}
