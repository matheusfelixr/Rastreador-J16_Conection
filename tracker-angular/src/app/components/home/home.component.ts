import { Component, OnInit } from '@angular/core';
import { DeviceService, Device } from '../../service/device.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  devices: Device[] = [];

  constructor(private deviceService: DeviceService, private router: Router) { }

  ngOnInit(): void {
    this.deviceService.getDevices().subscribe((data) => {
      this.devices = data;
    });
  }

  onCardClick(id: number): void {
    this.router.navigate(['/device-details', id]);
  }
}