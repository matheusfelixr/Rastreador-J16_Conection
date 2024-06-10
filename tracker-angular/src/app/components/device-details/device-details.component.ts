import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DeviceService } from '../../service/device.service';
import { Device } from '../../models/device.model';
import { Route } from '../../models/route.model'; // Importe a interface Route

@Component({
  selector: 'app-device-details',
  templateUrl: './device-details.component.html',
  styleUrls: ['./device-details.component.css']
})
export class DeviceDetailsComponent implements OnInit {
  device: any;
  errors: string[] = [];

  // Configurações do mapa
  center: google.maps.LatLngLiteral = { lat: 0, lng: 0 };
  zoom = 15;
  polylinePath: google.maps.LatLngLiteral[] = [];
  polylineOptions: google.maps.PolylineOptions = { strokeColor: '#FF0000', strokeOpacity: 1.0, strokeWeight: 2 };
  markers: google.maps.LatLngLiteral[] = [];


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
        this.setupMap(this.device.routes); // Configurar o mapa com as rotas
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

  setupMap(routes: Route[]): void {
    if (routes.length > 0) {
      // Centralize o mapa na última posição do array de rotas
      const lastRoute = routes[routes.length - 1];
      this.center = { lat: lastRoute.latitude, lng: lastRoute.longitude };
    
      // Crie o caminho do polyline a partir das rotas
      this.polylinePath = routes.map(route => ({ lat: route.latitude, lng: route.longitude }));

     
      // Adicione marcadores para cada rota
      this.markers = routes.map(route => ({
        lat: route.latitude,
        lng: route.longitude
      }));
    }
  }

  showAlert(): void {
    let errorMessage = 'Erros encontrados:\n';
    this.errors.forEach(error => {
      errorMessage += `- ${error}\n`;
    });
    alert(errorMessage);
  }
}
