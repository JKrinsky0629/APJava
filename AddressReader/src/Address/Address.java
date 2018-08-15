package Address;

public class Address {
    private String street;
    private String city;
    private String state;
    private String county;
    private String zipcode;

    public Address(String street, String city, String county, String state, String zipcode){
        this.street = street;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zipcode = zipcode;
    }
    public String getState() {
        return state;
    }

    public String toString(){
        String retString = "";

        retString += "Street " +  street + "\n";
        retString += "City " +  city + "\n";
        retString += "County " +  county + "\n";
        retString += "State " +  state + "\n";
        retString += "ZipCode " +  zipcode + "\n";

        return retString;

    }
} 
