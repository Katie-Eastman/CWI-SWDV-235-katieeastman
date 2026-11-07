<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Bank - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">

                <div class="card shadow p-4">

                    <h1 class="text-center mb-4">My Bank</h1>

                    <form action="/login" method="post">

                        <div class="mb-3">
                            <label class="form-label">Username</label>
                            <input
                                type="text"
                                name="username"
                                class="form-control"
                                required
                            >
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input
                                type="password"
                                name="password"
                                class="form-control"
                                required
                            >
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Log In
                        </button>

                    </form>

                    <hr>

                    <p class="text-muted text-center mb-1">
                        Sample accounts
                    </p>

                    <small class="text-center">
                        Alice: ajones / weak
                    </small>

                    <small class="text-center">
                        Bob: bjones / weak
                    </small>

                </div>

            </div>
        </div>
    </div>

</body>
</html>
