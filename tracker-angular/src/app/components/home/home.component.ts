import { Component, OnInit } from '@angular/core';
import { DeviceService } from '../../service/device.service';
import { Device } from '../../models/device.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  devices: Device[] = [];
  errors: string[] = []; 

  constructor(private deviceService: DeviceService, private router: Router) { }

  ngOnInit(): void {
    this.getDevices();
  }

  getDevices(): void {
    this.deviceService.getDevices().subscribe(response => {
      if (response.data) {
        this.devices = response.data;
      } else {
        if (response.errors && response.errors.length > 0) {
          this.errors = response.errors;
          this.showAlert();
        } else {
          console.error('Erro desconhecido ao buscar dispositivos.');
        }
      }
    });
  }

  onCardClick(id: number): void {
    this.router.navigate(['/device-details', id]);
  }
  showAlert(): void {
    let errorMessage = 'Erros encontrados:\n';
    this.errors.forEach(error => {
      errorMessage += `- ${error}\n`;
    });
    alert(errorMessage);
  }
}
