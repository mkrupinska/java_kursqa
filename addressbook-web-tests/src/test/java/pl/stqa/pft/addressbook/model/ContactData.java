package pl.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int id;

  @Expose
  @Column (name ="firstname")
  private String firstname;

  @Expose
  @Column (name ="lastname")
  private String lastname;

  @Column (name ="middlename")
  private String middlename;

  @Expose
  @Column (name ="address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column (name ="home")
  @Type(type = "text")
  private String homephone;

  @Column (name ="mobile")
  @Type(type = "text")
  private String mobilephone;

  @Column (name ="work")
  @Type(type = "text")
  private String workphone;

  @Transient
  private String allPhones;

  @Expose
  @Column (name ="email")
  @Type(type = "text")
  private String email;

  @Column (name ="email2")
  @Type(type = "text")
  private String email2;

  @Column (name ="email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;

  @Column (name ="fax")
  @Type(type = "text")
  private String fax;

  @Column (name = "company")
  private String company;

  @Expose
  @Column (name = "homepage")
  @Type(type = "text")
  private String homepage;

  @Transient
  private String bDay;

  @Transient
  private String bMonth;

  @Transient
  private String bYear;

  @Transient
  private String aDay;

  @Transient
  private String aMonth;

  @Transient
  private String aYear;

  @Transient
  @XStreamOmitField
  private String anniversary;

  @Transient
  @XStreamOmitField
  private String birthday;

  @Transient
  private String secAddress;

  @Transient
  private String secHomePhone;

  @Transient
  private String notes;

  @Expose
  @Column (name ="nickname")
  private String nickname;

  @Transient
  private String title;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name ="group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  @Transient
  private String photoPath;

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
  public ContactData inGroup (GroupData group){
    groups.add(group);
    return this;
  }

  public ContactData withPhoto (File photo) {
    this.photo = photo.getPath();
    //this.photoPath = photo.getAbsolutePath();
    return this;
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

  public Groups getGroups() {
    return new Groups(groups);
  }

  public String getPhotoPath()
  {
    return photoPath;
  }

  public File getPhoto() {
    if (photo == null){
      return null;
    }
    return new File(photo);

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homephone, that.homephone) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstname, lastname, address, homephone, email);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", homephone='" + homephone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

}
