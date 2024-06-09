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
   return this.http.get<Device[]>(this.apiUrl);
  }

  getDeviceById(id: number): Observable<Device> {
    return this.http.get<Device>(`${this.apiUrl}/${id}`);
  }
}