package pl.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String homephone;
  private final String email;
  private String group;

  public ContactData(String firstname, String lastname, String address, String homephone, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homephone = homephone;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
