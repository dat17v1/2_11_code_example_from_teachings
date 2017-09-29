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
    //private SqlRowSet sqlRowSet;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void create(User st) {

    }

    @Override
    public ArrayList<User> readAll() {

        SqlRowSet sqlRowSet;
        users.clear();
        //ArrayList<User> users = new ArrayList<>();
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user");
        while(sqlRowSet.next()){
            // indhold af sqlRowset ned i en arrayliste
           users.add(new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("name"), sqlRowSet.getString("email")));

            // TEST i Consollen
            int id = sqlRowSet.getInt("user_id");
            String name =  sqlRowSet.getString("name");
            String email =  sqlRowSet.getString("email");
            System.out.println(id + " " + name);
        }

        return users;
    }

    @Override
    public User read(int id) {

        User user = jdbc.queryForObject("SELECT * FROM user where user_id = 1", User.class);
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
