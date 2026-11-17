@import edu.cwi.data.User
@import edu.cwi.data.Account
@import edu.cwi.data.Transaction
@import java.util.List

@param String title
@param User user
@param Account account
@param List<Transaction> transactions

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet"
    >
</head>

<body class="bg-light">

<div class="container mt-5">

    <!-- Page heading and logout -->
    <div class="d-flex justify-content-between align-items-center mb-4">

        <div>
            <h1>Account Details</h1>
            <h4>${user.getFirstName()} ${user.getLastName()}</h4>
        </div>

        <form action="/logout" method="post">
            <button type="submit" class="btn btn-danger">
                Log Out
            </button>
        </form>

    </div>

    <!-- Account information -->
    <div class="card shadow p-4 mb-4">

        <h3 class="mb-3">Account Information</h3>

        <p>
            <strong>Account Number:</strong>
            ${account.getId()}
        </p>

        <p>
            <strong>Account Type:</strong>
            ${account.getAccountType()}
        </p>

        <h4 class="text-success">
            Balance: $${account.getBalance()}
        </h4>

    </div>

    <!-- Transaction history -->
    <div class="card shadow p-4 mb-4">

        <h3 class="mb-3">Transaction History</h3>

        @if(transactions.isEmpty())

            <p class="text-muted">
                No transactions to display.
            </p>

        @else

            <table class="table table-striped table-hover">

                <thead>
                    <tr>
                        <th>Transaction Type</th>
                        <th>Amount</th>
                        <th>Description</th>
                        <th>Date</th>
                    </tr>
                </thead>

                <tbody>

                    @for(Transaction transaction : transactions)

                        <tr>
                            <td>${transaction.getTransactionType()}</td>
                            <td>$${transaction.getAmount()}</td>
                            <td>${transaction.getDescription()}</td>
                            <td>${transaction.getCreatedAt().toString()}</td>
                        </tr>

                    @endfor

                </tbody>

            </table>

        @endif

    </div>

    <!-- Back button -->
    <a href="/accounts" class="btn btn-primary">
        Back to Accounts
    </a>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
