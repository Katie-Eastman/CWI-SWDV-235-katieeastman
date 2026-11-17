@import edu.cwi.data.User
@import edu.cwi.data.Account
@import java.util.List

@param String title
@param User user
@param List<Account> accounts

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

    <div class="d-flex justify-content-between align-items-center mb-4">

        <div>
            <h1>My Accounts</h1>
            <h4>Welcome, ${user.getFirstName()} ${user.getLastName()}!</h4>
        </div>

        <form action="/logout" method="post">
            <button type="submit" class="btn btn-danger">
                Log Out
            </button>
        </form>

    </div>

    <div class="card shadow p-4">

        <h3 class="mb-3">Your Accounts</h3>

        @for(Account account : accounts)

            <div class="border rounded p-3 mb-3">

                <p>
                    <strong>Account Number:</strong>
                    ${account.getId()}
                </p>

                <p>
                    <strong>Account Type:</strong>
                    ${account.getAccountType()}
                </p>

                <p>
                    <strong>Balance:</strong>
                    $${account.getBalance()}
                </p>

                <a
                    href="/account/${account.getId()}"
                    class="btn btn-primary"
                >
                    View Account Details
                </a>

            </div>

        @else

            <p>You don't have any accounts yet.</p>

        @endfor

    </div>

</div>

</body>
</html>
