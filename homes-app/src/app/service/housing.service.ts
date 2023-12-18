import {  Injectable } from '@angular/core';
import { HousingLocation } from '../interface/housing-location';


@Injectable({
  providedIn: 'root'
})
export class HousingService {

  constructor() { }

  async getAllHousingLocations() : Promise<HousingLocation[]> {
    const data = await fetch('http://localhost:8080/locationss');
    return await data.json() ?? [];
  }

  async getAllHousingLocationById(id : Number) : Promise<HousingLocation | undefined> {
    const data = await fetch(`http://localhost:8080/locationss/${id}`);
    return await data.json() ?? {};
  }

  // submitApplication(firstName : String, lastName: String, email:String){
  //   console.log(firstName, lastName, email);
    
  // }
}




  