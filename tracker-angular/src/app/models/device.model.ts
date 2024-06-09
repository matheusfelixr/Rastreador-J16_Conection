export class Device {
    constructor(
      public id: number,
      public nickname: string,
      public carName: string,
      public licensePlate: string,
      public latitude: number,
      public longitude: number,
      public imageUrl: string
    ) {}
  }