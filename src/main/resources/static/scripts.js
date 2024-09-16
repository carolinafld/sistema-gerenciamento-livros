document.addEventListener('DOMContentLoaded', function() {
    // Carregar livros na página de listagem
    if (document.getElementById('livros-lista')) {
        carregarLivros();
    }

    // Se estivermos na página de adicionar livro
    if (document.getElementById('form-adicionar-livro')) {
        document.getElementById('form-adicionar-livro').addEventListener('submit', function(event) {
            event.preventDefault();

            // Obter valores dos campos do formulário
            const titulo = document.getElementById('titulo').value.trim();
            const autor = document.getElementById('autor').value.trim();
            const anoPublicacao = document.getElementById('anoPublicacao').value.trim();
            const genero = document.getElementById('genero').value.trim();

            // Verificar se todos os campos estão preenchidos
            if (!titulo || !autor || !anoPublicacao || !genero) {
                alert('Todos os campos são obrigatórios.');
                return;
            }

            // Criar objeto livro
            const livro = { titulo, autor, anoPublicacao, genero };

            // Salvar livro no localStorage
            salvarLivro(livro);

            // Redirecionar para a página de listagem de livros
            window.location.href = 'listar-livros.html';
        });
    }
});

// Função para carregar livros do localStorage e exibi-los
function carregarLivros() {
    const livros = JSON.parse(localStorage.getItem('livros')) || [];
    const listaLivros = document.getElementById('livros-lista');
    listaLivros.innerHTML = ''; // Limpar lista antes de adicionar novos livros

    livros.forEach(livro => {
        const li = document.createElement('li');
        li.textContent = `${livro.titulo} - ${livro.autor} (${livro.anoPublicacao}) - ${livro.genero}`;
        listaLivros.appendChild(li);
    });
}

// Função para salvar livro no localStorage
function salvarLivro(livro) {
    let livros = JSON.parse(localStorage.getItem('livros')) || [];
    livros.push(livro);
    localStorage.setItem('livros', JSON.stringify(livros));
}
