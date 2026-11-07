
<%-- Java imports --%>
@import gg.jte.Content

<%-- Parameters --%>
@param String title = "My Bank"
@param Content account
@param Content detail

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet"
    >
</head>

<body>

    <div class="container mt-4">

        <div class="d-flex justify-content-end mb-4">
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-danger">
                    Log Out
                </button>
            </form>
        </div>

        <div class="row">
            <div class="col">
                ${account}
            </div>

            <div class="col">
                ${detail}
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
