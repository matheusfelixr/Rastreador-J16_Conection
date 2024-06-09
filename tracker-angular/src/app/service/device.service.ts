import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { Device } from '../models/device.model';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  private apiUrl = 'https://api.example.com/devices'; // URL da API

  constructor(private http: HttpClient) { }

  getDevices(): Observable<Device[]> {
 // Dados fictícios temporários
  const fakeDevices: Device[] = [
    { 
      id: 1, 
      nickname: 'Device 1', 
      carName: 'Car 1', 
      licensePlate: 'ABC123', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: '123456789', // Número do chip fictício
      phone: '+1234567890' // Número de telefone fictício
    },   { 
      id: 1, 
      nickname: 'Device 1', 
      carName: 'Car 1', 
      licensePlate: 'ABC123', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: '123456789', // Número do chip fictício
      phone: '+1234567890' // Número de telefone fictício
    },   { 
      id: 1, 
      nickname: 'Device 1', 
      carName: 'Car 1', 
      licensePlate: 'ABC123', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: '123456789', // Número do chip fictício
      phone: '+1234567890' // Número de telefone fictício
    },
    ];

  console.log(fakeDevices)

  // Simular atraso na chamada da API (opcional)
  return of(fakeDevices);


   // return this.http.get<Device[]>(this.apiUrl);
  }

  getDeviceById(id: number): Observable<Device> {
    return this.http.get<Device>(`${this.apiUrl}/${id}`);
  }
}