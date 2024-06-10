import { Route } from "./route.model";

export interface Device {
  id: number;
  nickname: string;
  carName: string;
  licensePlate: string;
  latitude: number;
  longitude: number;
  imageUrl: string;
  imei: string;
  chip: string;
  phone: string;
  createDate: Date; 
  routes: Route[]; 
}