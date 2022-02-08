import static org.apache.arrow.vector.types.Types.MinorType.FLOAT4;
import static org.apache.arrow.vector.types.Types.MinorType.INT;
import static org.apache.arrow.vector.types.Types.MinorType.VARCHAR;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.Float4Vector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.Schema;


public class DataBaseInteracting {
  private Connection connection;
  static final RootAllocator allocator = new RootAllocator(Long.MAX_VALUE);

  {
    try {
      connection = MakeConnection.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Person> searchForAll() {
    List<Person> listUser = new ArrayList<>();
    String sql = "SELECT * FROM personalData";
    Person person = null;
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setNumberrange(resultSet.getInt("numberrange"));
        person.setCurrency(resultSet.getFloat("currency"));
        listUser.add(person);
        System.out.println(person);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listUser;
  }

  public VectorSchemaRoot dataBaseToVectorSchemaRoot(List<Person> list) {
    int rowCount = 0;
    Schema schema = new Schema(Arrays.asList(
        Field.nullable("id", INT.getType()),
        Field.nullable("name", VARCHAR.getType()),
        Field.nullable("numberrange", INT.getType()),
        Field.nullable("currency", FLOAT4.getType()))
    );
    VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator);
    IntVector id = (IntVector) vectorSchemaRoot.getVector("id");
    VarCharVector name = (VarCharVector) vectorSchemaRoot.getVector("name");
    IntVector numberrange = (IntVector) vectorSchemaRoot.getVector("numberrange");
    Float4Vector currency = (Float4Vector) vectorSchemaRoot.getVector("currency");
    for (Person p : list) {
      id.setSafe(rowCount, p.getId());
      name.setSafe(rowCount, p.getName().getBytes(StandardCharsets.UTF_8));
      numberrange.setSafe(rowCount, p.getNumberrange());
      currency.setSafe(rowCount, p.getCurrency());
      ++rowCount;
    }
    vectorSchemaRoot.setRowCount(rowCount);
    return vectorSchemaRoot;
  }
}
