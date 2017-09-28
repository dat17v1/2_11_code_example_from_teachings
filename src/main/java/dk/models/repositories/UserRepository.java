package dk.models.repositories;

import dk.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by clbo on 28/09/2017.
 */

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void create(User st) {

    }

    @Override
    public ArrayList<User> readAll() {
        return null;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
