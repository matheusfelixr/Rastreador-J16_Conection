import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  login() {
    // Aqui você pode adicionar a lógica para o login, como chamar um serviço de autenticação
    console.log('Usuário:', this.username);
    console.log('Senha:', this.password);
    // Exemplo de verificação simples
    if (this.username === 'admin' && this.password === 'admin') {
      alert('Login bem-sucedido!');
    } else {
      alert('Nome de usuário ou senha incorretos');
    }
  }
}