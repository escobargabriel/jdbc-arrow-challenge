import java.sql.SQLException;
import java.util.List;

import org.apache.arrow.vector.VectorSchemaRoot;

public class Main {
  public static void main(String[] args) throws SQLException {
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    List<Person> list = dataBaseInteracting.searchForAll();
    VectorSchemaRoot vectorSchemaRoot = dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
    System.out.println(vectorSchemaRoot.getFieldVectors());
  }
}
