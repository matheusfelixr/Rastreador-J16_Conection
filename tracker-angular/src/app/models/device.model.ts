export interface Device {
  id: number;
  nickname: string;
  carName: string;
  licensePlate: string;
  latitude: number;
  longitude: number;
  imageUrl: string;
  imei: string; // Adiciona o IMEI
  chip: string; // Adiciona o número do chip
  phone: string; // Adiciona o número de telefone
}