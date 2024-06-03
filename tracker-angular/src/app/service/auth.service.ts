import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  login(user: string, password: string): boolean {
    if (user === 'matheus.ribeiro' && password === '123456789') {
      localStorage.setItem('Logged', 'true');
      localStorage.setItem('photo', 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg');
      
      return true;
    } else {
      return false;
    }
  }

  isLogged(): boolean {
    return localStorage.getItem('Logged') === 'true';
  }

  logout(): void {
    localStorage.clear();
    window.location.href = '/';
  }

  getPhoto(){
    return localStorage.getItem('photo');
  }
}