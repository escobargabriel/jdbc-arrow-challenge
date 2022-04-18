import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.arrow.vector.VectorSchemaRoot;

public class Main {
  public static void main(String[] args) throws SQLException {
    DataBaseInteracting dataBaseInteracting = new DataBaseInteracting();
    try(PreparedStatement preparedStatement = dataBaseInteracting.createPrepareStatement();
        ResultSet aResultSet = dataBaseInteracting.createResultSet(preparedStatement);) {
      List<Person> list = dataBaseInteracting.searchForAll(aResultSet);
      VectorSchemaRoot vectorSchemaRoot =
          dataBaseInteracting.dataBaseToVectorSchemaRoot(list);
      System.out.println(vectorSchemaRoot.getFieldVectors());
    }
  }
}
