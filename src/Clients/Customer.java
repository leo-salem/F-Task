package Clients;

public class Customer {
    private String Name;
    private int Money;
    public Customer() {}
    public Customer(String name, int money) {
        Name = name;
        Money = money;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getMoney() {
        return Money;
    }
    public void setMoney(int money) {
        Money = money;
    }
}

