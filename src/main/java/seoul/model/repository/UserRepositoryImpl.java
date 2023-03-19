package seoul.model.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import seoul.model.entity.User;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void signUp(User entity) throws RuntimeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append(" INSERT INTO /* signUp */ user ");
            query.append("  (account, password, name, phone_number, created_at, updated_at) ");
            query.append("  VALUES (:account, :password, :name, :phoneNumber, :createdAt, :updatedAt) ");

            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("account", entity.getAccount());
            params.addValue("password", entity.getPassword());
            params.addValue("name", entity.getName());
            params.addValue("phoneNumber", entity.getPhoneNumber());
            params.addValue("createdAt", entity.getCreatedAt());
            params.addValue("updatedAt", entity.getUpdatedAt());

            jdbcTemplate.update(query.toString(), params);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("API 처리 도중 오류가 발생했습니다.");
        }
    }

    @Override
    public Long hasAccount(String account) {
        try {
            String query = " SELECT id FROM user WHERE account = :account ";

            return jdbcTemplate.queryForObject(query, new MapSqlParameterSource("account", account), Long.class);
        } catch (Exception e) {
            return 0L;
        }
    }
}
