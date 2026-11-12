package edu.cwi.data;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface TransactionMapper {

    @Select("SELECT transaction_id AS id, account_id, transaction_type, amount, description, created_at FROM transactions")
    List<Transaction> getAllTransactions();

    @Select("SELECT transaction_id AS id, account_id, transaction_type, amount, description, created_at FROM transactions WHERE transaction_id = #{id}")
    Transaction getById(long id);

    @Select("SELECT transaction_id AS id, account_id, transaction_type, amount, description, created_at FROM transactions WHERE account_id = #{accountId}")
    List<Transaction> getByAccountId(int accountId);

    @Insert("INSERT INTO transactions (account_id, transaction_type, amount, description) VALUES (#{accountId}, #{transactionType}, #{amount}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "transaction_id")
    int insert(Transaction transaction);

    @Delete("DELETE FROM transactions WHERE transaction_id = #{id}")
    int delete(long id);
}
