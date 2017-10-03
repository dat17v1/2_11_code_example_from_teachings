package dk.models.repositories;

import dk.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;

/**
 * Created by clbo on 28/09/2017.
 */

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(User st) {
        jdbc.update("INSERT INTO user(name, email) VALUES('" + st.getName() + "', '" + st.getEmail() + "') ");
    }

    @Override
    public ArrayList<User> readAll() {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user");
        ArrayList<User> users = new ArrayList<>();

        while(sqlRowSet.next()){
            // indhold af sqlRowset ned i en arrayliste
           users.add(new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("name"), sqlRowSet.getString("email")));

        }

        return users;
    }

    @Override
    public User read(int id) {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE user_id =" + id);

        if(sqlRowSet.next()){

            return new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("name"), sqlRowSet.getString("email"));

        }

        return new User();

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
