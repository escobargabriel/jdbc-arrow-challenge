import java.util.List;

public class Main {
  public static void main(String[] args) {
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    List<Person> list = dataBaseInteracting.searchForAll();
    dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
  }
}
