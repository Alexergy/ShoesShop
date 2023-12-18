package Back;

import java.util.ArrayList;

public class DataBase {//содержит все данные - аккаунты клиентов, инфу со склада, изменяет кол-во вещей на складе
    
    public static ArrayList <Client> clients = new ArrayList<>();
    public static ArrayList <MoneyAndService> services = new ArrayList<>();
//    static ArrayList <Shoes> shoes = new ArrayList();
//    static ArrayList <DetailsForFixing> details = new ArrayList();
    
    public static Shoes[] shoes = new Shoes[5];
    public static DetailsForFixing[] details = new DetailsForFixing[3];
    public static Fixing[] fixing = new Fixing[3];
    
    //public static double moneyCost = 0;
    
    
    public static void clientsDataBase(){
        Client client1 = new Client("Noskova", "Alexandra", 555555, "Alexer", 123123, 1234, 20000);
        Client client2 = new Client("Ovechkin", "Nikolay", 569023, "Nikola", 234234, 1234, 10000);
        Client client3 = new Client("Berenshtein", "Viktoria", 670032, "Viki", 345345, 1234, 10000);
        Client client4 = new Client("Semenova", "Ksenia", 324112, "Ksuuu", 345678, 2345, 23000);
        Client client5 = new Client("1", "1", 1, "1", 111111, 1111, 100000);
        
        
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
    }
   
    public static void shoesDataBase(){
        shoes[0] = new Shoes ("туфли", 3500, 25);
        shoes[1] = new Shoes ("ботильоны", 7500, 25);
        shoes[2] = new Shoes ("сапоги", 5500, 25);
        shoes[3] = new Shoes ("кросовки", 4000, 25);
        shoes[4] = new Shoes ("ботинки", 3800, 25);
        
//        Shoes shoes1 = new Shoes ("туфли", 3500, 25);
//        Shoes shoes2 = new Shoes ("сапого", 5500, 25);
//        Shoes shoes3 = new Shoes ("кросовки", 4000, 25);
//        Shoes shoes4 = new Shoes ("ботинки", 3800, 25);
//        Shoes shoes5 = new Shoes ("ботильоны", 7500, 25);
//        shoes.add(shoes1);
//        shoes.add(shoes2);
//        shoes.add(shoes3);
//        shoes.add(shoes4);
//        shoes.add(shoes5);
    }
//    
    public static void detailsDataBase(){
        details[0] = new DetailsForFixing ("лак", 1);
        details[1] = new DetailsForFixing ("банка клея", 35);
        details[2] = new DetailsForFixing ("каблук", 55);
        
//        DetailsForFixing details1 = new DetailsForFixing ("лак", 35);
//        DetailsForFixing details2 = new DetailsForFixing ("банка клея", 35);
//        DetailsForFixing details3 = new DetailsForFixing ("каблук", 55);
//        
//        details.add(details1);
//        details.add(details2);
//        details.add(details3);
    }
    
    public static void fixingDataBase(){
        fixing[0] = new Fixing ("Лакировка", 2500, "лак");
        fixing[1] = new Fixing ("Починка подошвы", 2000, "банка клея");
        fixing[2] = new Fixing ("Починка каблука", 3500, "каблук");
    }

    public static class services {

        public services() {
        }
    }
}
