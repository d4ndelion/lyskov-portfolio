function copyEmail(email) {
    navigator.clipboard.writeText(email).then(function () {
        var toast = document.getElementById('copy-toast');
        toast.classList.add('copy-toast--visible');
        setTimeout(function () {
            toast.classList.remove('copy-toast--visible');
        }, 2500);
    });
}
