package edu.cwi.data;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface AccountMapper {

    @Select("SELECT account_id AS id, user_id, account_type, balance FROM accounts")
    List<Account> getAllAccounts();

    @Select("SELECT account_id AS id, user_id, account_type, balance FROM accounts WHERE account_id = #{id}")
    Account getById(int id);

    @Select("SELECT account_id AS id, user_id, account_type, balance FROM accounts WHERE user_id = #{userId}")
    List<Account> getByUserId(int userId);

    @Insert("INSERT INTO accounts (user_id, account_type, balance) VALUES (#{userId}, #{accountType}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "account_id")
    int insert(Account account);

    @Update("UPDATE accounts SET user_id = #{userId}, account_type = #{accountType}, balance = #{balance} WHERE account_id = #{id}")
    int update(Account account);

    @Delete("DELETE FROM accounts WHERE account_id = #{id}")
    int delete(int id);
}
