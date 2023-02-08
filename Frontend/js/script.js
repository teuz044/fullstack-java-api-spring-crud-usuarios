const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Isenha = document.querySelector(".senha");
const Iemail = document.querySelector(".email");

function cadastar () {

    fetch ("http://localhost:8080/",
{
    headears: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({a: 1, b: 2 })
})
.then(function(res) {console.log(res) })
.catch(function(res) {console.log(res) })
};

function limpar () {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    const dados = {
        nome: Inome.value,
        email: Iemail.value,
        senha: Isenha.value
    }
    console.log(dados);
    limpar()
})