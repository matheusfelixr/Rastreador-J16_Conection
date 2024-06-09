import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DeviceService } from '../../service/device.service';
import { Device } from '../../models/device.model';

@Component({
  selector: 'app-device-details',
  templateUrl: './device-details.component.html',
  styleUrls: ['./device-details.component.css']
})
export class DeviceDetailsComponent implements OnInit {
  device: any ;
  errors: string[] = []; 


  constructor(
    private route: ActivatedRoute,
    private deviceService: DeviceService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id !== null) {
        this.getDeviceById(+id);
      } else {
        console.error('ID do dispositivo não está presente na URL');
      }
    });
  }

  getDeviceById(id: number): void {
    this.deviceService.getDeviceById(id).subscribe(response => {
      if (response.data) {
        this.device = response.data;
        console.log(this.device)
      } else {
        if (response.errors && response.errors.length > 0) {
          this.errors = response.errors;
          this.showAlert();
        } else {
          console.error('Erro desconhecido ao buscar dispositivo.');
        }
      }
    });
  }

  showAlert(): void {
    let errorMessage = 'Erros encontrados:\n';
    this.errors.forEach(error => {
      errorMessage += `- ${error}\n`;
    });
    alert(errorMessage);
  }
}
