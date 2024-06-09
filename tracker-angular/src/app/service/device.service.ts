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
    { id: 1, nickname: 'Device 1', carName: 'Car 1', licensePlate: 'ABC123', latitude: 10.1234, longitude: -20.5678, imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg' },
    { id: 2, nickname: 'Device 2', carName: 'Car 2', licensePlate: 'DEF456', latitude: 20.5678, longitude: -30.9012, imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg' },
    { id: 3, nickname: 'Device 3', carName: 'Car 3', licensePlate: 'GHI789', latitude: 30.9012, longitude: -40.1234, imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg' }
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