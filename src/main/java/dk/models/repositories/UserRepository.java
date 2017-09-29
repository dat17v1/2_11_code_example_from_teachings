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
    public void create(User user) {
        jdbc.update("INSERT INTO user (name, email) VALUES ("+ user.getName() + "," + user.getEmail() + ")");

    }

    @Override
    public ArrayList<User> readAll() {

        SqlRowSet sqlRowSet;
        ArrayList<User> users = new ArrayList<>();

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user");

        while(sqlRowSet.next()){

           users.add(new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("name"), sqlRowSet.getString("email")));
        }

        return users;
    }

    @Override
    public User read(int id) {

        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user where user_id =" + id + "");

        while(sqlRowSet.next()){

            return new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("name"), sqlRowSet.getString("email"));
        }

        // if no user found return an empty user
        return new User();
    }

    @Override
    public void update(User user) {
        jdbc.update("UPDATE user SET name = '" + user.getName() + "' , email = '" + user.getEmail() + "' WHERE user_id = " + user.getUserId());
    }

    @Override
    public void delete(int id) {
        jdbc.update("DELETE FROM user WHERE user_id = " + id);
    }
}
