package pl.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String firstname;
  private String lastname;
  private String address;
  private String homephone;
  private String mobilephone;
  private String workphone;
  private String allPhones;
  private String email;
  private String group = "test1";

  public ContactData withId (int id){
    this.id = id;
    return this;
  }
  public ContactData withFirstName (String firstname) {
    this.firstname = firstname;
    return this;
  }
  public ContactData withLastName (String lastname) {
    this.lastname = lastname;
    return this;
  }
  public ContactData withAddress (String address) {
    this.address = address;
    return this;
  }
  public ContactData withHomephone (String homephone) {
    this.homephone = homephone;
    return this;
  }
  public ContactData withEmail (String email) {
    this.email = email;
    return this;
  }
  public ContactData withGroup (String group) {
    this.group = group;
    return this;
  }
  public ContactData withMobilephone (String mobilephone){
    this.mobilephone = mobilephone;
    return this;
  }
  public ContactData withWorkphone (String workphone){
    this.workphone = workphone;
    return this;
  }
  public ContactData withAllPhones (String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstname, lastname);
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

  public String getMobilephone() {
    return mobilephone;
  }

  public String getWorkphone() {
    return workphone;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAllPhones() {
    return allPhones;
  }

}
