const form = document.querySelector(".loginForm");
const messages = form.querySelector(".errorMessages-list");
const matricula = form.querySelector("#matricula");
const senha = form.querySelector("#senha");

form.onsubmit = event => {
    event.preventDefault();

    messages.innerHTML = ""; //clear messages
    const usuario = { matricula: matricula.value, senha: senha.value };
    if (usuario.matricula.startsWith("aluno")) {
        document.location.href = "home_aluno.html";
        return;
    } else if (usuario.matricula.startsWith("instrutor")) {
        document.location.href = "home_instrutor.html";
        return;
    }

    addErrorMessage("Erro ao realizar login, certifique-se de que suas credenciais estão corretas e tente novamente");
    matricula.focus();
}

function addErrorMessage(message) {
    const item = document.createElement("li");
    item.classList.add("errorMessages-list-item");
    item.innerHTML = message;
    messages.appendChild(item);
}