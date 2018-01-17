package pl.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id;
  @Expose
  private String firstname;
  @Expose
  private String lastname;
  private String middlename;
  @Expose
  private String address;
  @Expose
  private String homephone;
  private String mobilephone;
  private String workphone;
  private String allPhones;
  @Expose
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String fax;
  private String company;
  @Expose
  private String homepage;
  private String bDay;
  private String bMonth;
  private String bYear;;
  private String aDay;
  private String aMonth;
  private String aYear;
  @XStreamOmitField
  private String anniversary;
  @XStreamOmitField
  private String birthday;
  private String secAddress;
  private String secHomePhone;
  private String notes;
  @Expose
  private String nickname;
  private String title;
  @XStreamOmitField
  private File photo;
  @XStreamOmitField
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
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withEmail2(String email2){
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3){
    this.email3 = email3;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBirdhday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  public ContactData withAnniversary(String anniversary) {
    this.anniversary = anniversary;
    return this;
  }

  public ContactData withSecAddress(String secAddress) {
    this.secAddress = secAddress;
    return this;
  }

  public ContactData withSecHomePhone(String secHomePhone) {
    this.secHomePhone = secHomePhone;
    return this;
  }
  public ContactData withNotes (String notes) {
    this.notes = notes;
    return this;
  }
  public ContactData withBDay (String bDay){
    this.bDay = bDay;
    return this;
  }

  public ContactData withBMonth(String bMonth) {
    this.bMonth = bMonth;
    return this;
  }

  public ContactData withBYear(String bYear) {
    this.bYear = bYear;
    return this;
  }

  public ContactData withADay(String aDay) {
    this.aDay = aDay;
    return this;
  }

  public ContactData withAMonth(String aMonth) {
    this.aMonth = aMonth;
    return this;
  }

  public ContactData withAYear(String aYear) {
    this.aYear = aYear;
    return this;
  }
  public ContactData withNickname (String nickname){
    this.nickname = nickname;
    return this;
  }
  public ContactData withTitle (String title){
    this.title = title;
    return this;
  }
  public ContactData withFax (String fax){
    this.fax = fax;
    return this;
  }

  public ContactData withPhoto (File photo) {
    this.photo = photo;
    return this;
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

  public int getId() {
    return id;
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

  public String getMobilephone() {
    return mobilephone;
  }

  public String getWorkphone() {
    return workphone;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getCompany() {
    return company;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBDay() {
    return bDay;
  }

  public String getAnniversary() {
    return anniversary;
  }

  public String getSecAddress() {
    return secAddress;
  }

  public String getSecHomePhone() {
    return secHomePhone;
  }

  public String getFax() {
    return fax;
  }

  public String getNotes() {
    return notes;
  }

  public String getBMonth() {
    return bMonth;
  }

  public String getBYear() {
    return bYear;
  }

  public String getADay() {
    return aDay;
  }

  public String getAMonth() {
    return aMonth;
  }

  public String getAYear() {
    return aYear;
  }

  public String getBirthday() {
    return birthday;
  }
  public String getNickname (){
    return nickname;
  }
  public String getTitle (){
    return title;
  }

  public File getPhoto() {
    return photo;
  }
}
