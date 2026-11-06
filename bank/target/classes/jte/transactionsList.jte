@import java.util.Map

@param Map<String, String> transactions

<h1>Transactions</h1>

<ul>
    @for(var entry : transactions.entrySet())
        <li>${entry.getKey()}: ${entry.getValue()}</li>
    @else
        <li>You have no transactions to display.</li>
    @endfor
</ul>

<h2>Add a Transaction</h2>

<form action="/transactions" method="post">

    <div class="mb-3">
        <label for="description" class="form-label">
            Transaction Description
        </label>

        <input
            type="text"
            class="form-control"
            id="description"
            name="description"
            placeholder="Enter a transaction"
            required
        >
    </div>

    <button type="submit" class="btn btn-primary">
        Add Transaction
    </button>

</form>