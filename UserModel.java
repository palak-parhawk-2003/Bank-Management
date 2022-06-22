public class UserModel {
    private String name,phoneno,email,address,passowrd;
    private double balance;
    int id;
    public UserModel(String name,String phoneno,String email,String address,String password,double balance)
    {
        this.address = address;
        this.balance = balance;
        this.email = email;
        this.name = name;
        this.passowrd = password;
        this.phoneno = phoneno;
    }
    public UserModel(int id,String name,String phoneno,String email,String address,String password,double balance)
    {
        this.address = address;
        this.balance = balance;
        this.email = email;
        this.name = name;
        this.passowrd = password;
        this.phoneno = phoneno;
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getPhoneNo()
    {
        return this.phoneno;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getPassword()
    {
        return this.passowrd;
    }
    public double getBalance()
    {
        return this.balance;
    }
    
}
