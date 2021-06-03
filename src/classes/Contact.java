package classes;


public class Contact  {
    private int Id;
    private String Firstname;
    private String Lastname;
    private String Address;

    public Contact(int Id, String Firstname, String Lastname, String Address){
        this.Id = Id;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Address = Address;
    }

    public Contact(){
        
    }
        
    // сеттери
    public void setId(int Id){
        this.Id = Id;
    }
    
    public void setFirstname(String Firstname){
        this.Firstname = Firstname;
    }
    
    public void setLastname(String Lastname){
        this.Lastname = Lastname;
    }
    
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    // геттери
    public int getId(){
        return this.Id;
    }
    
    public String getContactFirstname(){
        return this.Firstname;
    }
     
    public String getContactLastname(){
        return this.Lastname;
    }
    
    public String getContactAddress(){
        return this.Address;
    }

    @Override
    public String toString() {
        return "Інформація про контакт:\nId контакту: " + Id + "\nІм'я: " + Firstname + "\nПрізвище: " + Lastname + "\nАдреса: " + Address + "\n";
    }



}

