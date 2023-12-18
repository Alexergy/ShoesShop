package Back;

public class Client {

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSername() {
        return sername;
    }
//хранит данные о клиентах магазина
    
    private final String username;//имя для входа в аккаунт
    private final String name;//имя клиента
    private final String sername;//фамилия клиента
    private final int code;//личноый код для входа в аккаунт
    
    //info about card and money
    private int cardNumber; //номер карты клиента
    private int cardCode; //пароль от карты клиенты
    private double moneyOnCard; //средства на карте
    
    public Client(String name, String sername, int code, String username, 
    		int cardNumber, int cardCode, double moneyOnCard){//запись данные клиента
        this.name = name;
        this.sername = sername;
        this.code = code;
        this.username = username;
        
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
        this.moneyOnCard = moneyOnCard;
    }

    public int getCode() {
        return code;
    }
    
    public int getCardNumber() {
        return cardNumber;
    }
    
    public int getСardCode() {
        return cardCode;
    }
    
    public double getMoneyOnCard() {
        return moneyOnCard;
    }
    
    public void setLessMoneyOnCerd(double spendMoney) {
    	this.moneyOnCard -= spendMoney;
    }
}

