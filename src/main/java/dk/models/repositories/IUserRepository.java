package dk.models.repositories;

import dk.models.entities.User;

import java.util.ArrayList;

/**
 * Created by clbo on 27/09/2017.
 */
public interface IUserRepository {

    // Create
    public void create(User st);

    // Read
    public ArrayList<User> readAll();
    public User read(int id);

    // Update
    public void update(User user);

    // Delete
    public void delete(int id);
}
