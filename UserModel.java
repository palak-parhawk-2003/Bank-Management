public class UserModel {
    private String name,phoneno,email,address,passowrd;
    private double balance;
    private int id;
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
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPhoneNo()
    {
        return this.phoneno;
    }
    public void setPhoneNo(String phoneno)
    {
        this.phoneno = phoneno;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getPassword()
    {
        return this.passowrd;
    }
    public void setPassowrd(String passowrd)
    {
        this.passowrd = passowrd;
    }
    public double getBalance()
    {
        return this.balance;
    }
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }
}
