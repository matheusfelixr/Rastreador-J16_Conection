import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Device {
  id: number;
  nickname: string;
  carName: string;
  licensePlate: string;
  latitude: number;
  longitude: number;
  imageUrl: string;
}

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  private apiUrl = 'https://api.example.com/devices'; // URL da API

  constructor(private http: HttpClient) { }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.apiUrl);
  }
}