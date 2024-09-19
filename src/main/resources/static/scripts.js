document.addEventListener('DOMContentLoaded', function () {
    // Função para adicionar validação ao formulário de adicionar livro
    const formAdicionarLivro = document.querySelector('#form-adicionar-livro');
    if (formAdicionarLivro) {
        formAdicionarLivro.addEventListener('submit', function (event) {
            const titulo = document.querySelector('#titulo').value.trim();
            const autor = document.querySelector('#autor').value.trim();
            const anoPublicacao = document.querySelector('#anoPublicacao').value.trim();
            const genero = document.querySelector('#genero').value.trim();

            // Validação simples para garantir que todos os campos foram preenchidos
            if (titulo === '' || autor === '' || anoPublicacao === '' || genero === '') {
                event.preventDefault();
                alert('Por favor, preencha todos os campos!');
                return false;
            }

            // Validação extra: verifica se o ano de publicação é um número válido
            if (isNaN(anoPublicacao) || anoPublicacao.length !== 4) {
                event.preventDefault();
                alert('Por favor, insira um ano de publicação válido (quatro dígitos)!');
                return false;
            }
        });
    }

    // Função para confirmar exclusão de livro
    const deleteForms = document.querySelectorAll('.delete-form');
    deleteForms.forEach(form => {
        form.addEventListener('submit', function (event) {
            if (!confirm('Tem certeza de que deseja excluir este livro?')) {
                event.preventDefault();
            }
        });
    });
});
