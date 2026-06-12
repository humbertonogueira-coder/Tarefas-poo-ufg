import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class SensorRepository
{
    private static Database database;
    private static Dao<Sensor, Integer> dao;
    private List<Sensor> loadedSensores;
    private Sensor loadedSensor; 
    
    public SensorRepository(Database database) {
        SensorRepository.setDatabase(database);
        loadedSensores = new ArrayList<Sensor>();
    }
    
    public static void setDatabase(Database database) {
        SensorRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Sensor.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Sensor.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Sensor create(Sensor sensor) {
        int nrows = 0;
        try {
            nrows = dao.create(sensor);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedSensor = sensor;
            loadedSensores.add(sensor);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sensor;
    }    

    public void update(Sensor sensor) {
      // TODO
    }

    public void delete(Sensor sensor) {
      // TODO
    }
    
    public Sensor loadFromId(int id) {
        try {
            this.loadedSensor = dao.queryForId(id);
            if (this.loadedSensor != null)
                this.loadedSensores.add(this.loadedSensor);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedSensor;
    }    
    
    public List<Sensor> loadAll() {
        try {
            this.loadedSensores =  dao.queryForAll();
            if (this.loadedSensores.size() != 0)
                this.loadedSensor = this.loadedSensores.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedSensores;
    }

    // getters and setters ommited...        
}
