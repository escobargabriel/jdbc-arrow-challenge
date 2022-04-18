import static java.util.Arrays.asList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Tests {
  /*
  @Test
  public void listSize() throws SQLException {
    Person person1 = mock(Person.class);
    Person person2 = mock(Person.class);
    Person person3 = mock(Person.class);
    DataBaseInteracting dataBaseInteracting = mock(DataBaseInteracting.class);
    ResultSet resultSet = mock(ResultSet.class);
    List<Person> personList = Arrays.asList(person1, person2, person3);
    List<Person> list = dataBaseInteracting.searchForAll(resultSet);
    when(dataBaseInteracting.get);
  }
  */

  @Test
  void createPreparedStatementTest() throws SQLException {
  }
  @Test
  void createResultSetTest() {
  }
  @Test
  void searchForAllTest() throws SQLException {
  }
  @Test
  void dataBaseToVectorSchemaRootTestIfListIsEmpty() throws SQLException {
    Person p = new Person();
    List<Person> list = new ArrayList<>();
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
  }

  @Test
  void dataBaseToVectorSchemaRootTestList() throws SQLException {
    Person p1 = new Person(1, "João Canabrava", 2, 3.2f);
    Person p2 = new Person(2, "Pedro", 5, 9.2f);
    Person p3 = new Person(3,"Luiz", 6, 4.2f);
    Person p4 = new Person(4,"Maria", 2, 2.2f);
    Person p5 = new Person(5, "Jose", 4, 5.2f);
    Person p6 = new Person(6, "Iury", 8, 9.2f);
    Person p7 = new Person(7,"Rafael", 9, 2.2f);
    Person p8 = new Person(8,"Vinicius", 1, 3.9f);
    Person p9 = new Person(9,"Gabriel", 3, 0.2f);
    List<Person> list = new ArrayList<Person>();
    list.addAll(asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
  }
 }
