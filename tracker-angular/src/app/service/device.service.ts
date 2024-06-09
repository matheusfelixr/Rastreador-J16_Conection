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
      nickname: 'Classic j16', 
      carName: 'GM/Classic 2012', 
      licensePlate: 'OLV-9947', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: 'TIM', // Número do chip fictício
      phone: '+34 99186-7176' // Número de telefone fictício
    },{ 
      id: 2, 
      nickname: 'Corsa j16', 
      carName: 'GM/Corsa 2012', 
      licensePlate: 'AJY-7586', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: 'OI', // Número do chip fictício
      phone: '+34 99123-9845' // Número de telefone fictício
    },{ 
      id: 3, 
      nickname: 'S10 j16', 
      carName: 'GM/S10 2012', 
      licensePlate: 'WLV-9577', 
      latitude: 10.1234, 
      longitude: -20.5678, 
      imageUrl: 'https://italo.com.br/wp-content/uploads/2024/01/garoto-de-tiro-medio-trapaceando-no-teste-da-escola.jpg', 
      imei: '123456789012345', // IMEI fictício
      chip: 'CLARO', // Número do chip fictício
      phone: '+34 99656-7234' // Número de telefone fictício
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