import java.util.List;

import Seminar_7.model.Fields;
import Seminar_7.model.Repository;
import Seminar_7.model.User;
import Seminar_7.utils.Validate;

public class UserController {
    private final Repository repository;
    private final Validate validate;

    public UserController(Repository repository, Validate validate) {
        this.repository = repository;
        this.validate = validate;
    }

    public void saveUser(User user) throws Exception {
        validate.checkNumber(user.getPhone());
        repository.CreateUser(user);
    }
    public void updateUser(User user,Fields field, String param) throws Exception {
        if(field == Fields.TELEPHONE) {
            validate.checkNumber(param);
        }
        repository.UpdateUser(user, field, param);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }
    public List <User> getUsers() throws Exception {
        return repository.getAllUsers();
    }
    public void deleteUser(User user) throws Exception {
        repository.delUser(user);}
}
