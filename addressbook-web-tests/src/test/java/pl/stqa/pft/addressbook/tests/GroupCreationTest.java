package pl.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    try ( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }}

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try (BufferedReader reader =  new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // List<GroupData>.class
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator(); } }



  @Test (dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {

    Groups before = app.db().groups();
    app.goTo().groupPage();
    app.group().create(group);
    assertThat(app.group().count() , equalTo( before.size() + 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));

  }
  @Test (enabled = true)
  public void testBadGroupCreation() {
    Groups before = app.db().groups();
    app.goTo().groupPage();
    GroupData group = new GroupData().withHeader("test1'h").withFooter("test2f").withName("testn");
    app.group().create(group);
    assertThat(app.group().count() , equalTo( before.size() ));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before));

  }

}
