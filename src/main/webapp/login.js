document.addEventListener("DOMContentLoaded", () => {
    document.querySelector("#loginform").addEventListener("submit", (e) => {
        e.preventDefault();
        const username = document.querySelector("#username").value;
        const passwort = document.querySelector("#passwort").value;
        const url = "./resource/user/login";
        const options = {
            method: "POST",
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: `username=${username}&passwort=${passwort}`,
        };
        fetch(url, options)
            .then((response) => {
                if (response.status == 200) {
                    window.location.href =
                        "./index.html";
                } else {
                    document.querySelector("#message").innerHTML = "Invalid username or passwort";
                }
            })
            .catch((error) => {
                console.log(error);
            });
    });
});
