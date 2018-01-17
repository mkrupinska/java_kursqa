package pl.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

 /* @Test
  public void testCurrentDir() {
    File currentDir = new File (".");
    System.out.println(currentDir.getAbsolutePath());}
*/

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main (String [] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contact = generatorConacts(count);
    if (format.equals("csv")){
      saveAsCsv(contact, new File(file));
    } else if (format.equals("xml")){
      saveAsXml (contact, new File(file));
    } else if (format.equals("json")){
      saveAsJson (contact, new File(file));
    } else{
      System.out.println("unrecognized format " + format);
    }

  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }


  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  private static void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact:contacts) {
      writer.write(String.format("%s;%s;%s,%s,%s,%s,%s\n", contact.getLastname(), contact.getFirstname(), contact.getHomephone(), contact.getAddress(),
              contact.getHomephone(), contact.getPhoto(), contact.getGroup()));
    }
    writer.close();
  }

  private static List<ContactData> generatorConacts(int count) {
    List <ContactData> contact = new ArrayList<ContactData>();
    for (int i = 0; i<count; i++) {
      contact.add(new ContactData().withFirstName(String.format("testFN %s", i)).withLastName(String.format("testLM %s", i)).withHomephone(String.format("homephone %s", i))
              .withAddress(String.format("Adress Test %s", i)).withEmail(String.format("email@%s", i)).withHomepage(String.format("testHomepage %s", i)).withMobilephone(String.format("mobileTest%s", i))
              .withNickname(String.format("tnickname%s", i)).withPhoto(new File("src/test/resources/stru.png")).withGroup("test1"));
    }
    return contact;
  }

}






