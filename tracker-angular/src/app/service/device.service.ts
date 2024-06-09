import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Device } from '../models/device.model'; // Importe o modelo de dispositivo, se existir

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  private baseUrl = 'http://localhost:8080/devices'; // Coloque a URL do seu backend aqui

  constructor(private http: HttpClient) { }

  createDevice(device: Device): Observable<any> {
    return this.http.post(`${this.baseUrl}/create`, device);
  }

  getDevices(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  getDeviceById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}