package seoul.model.repository;

import seoul.model.entity.User;

public interface UserRepository {

    void signUp(User entity) throws RuntimeException;

    Long hasAccount(String account);
}
