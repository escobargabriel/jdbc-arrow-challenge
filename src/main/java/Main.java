import java.util.List;

import org.apache.arrow.vector.VectorSchemaRoot;

public class Main {
  public static void main(String[] args) {
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    List<Person> list = dataBaseInteracting.searchForAll();
    VectorSchemaRoot vectorSchemaRoot = dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
    System.out.println(vectorSchemaRoot.getFieldVectors());
  }
}
