import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HousingService } from '../service/housing.service';
import { HousingLocation } from '../interface/housing-location';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule,HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  template: `
    <article>
      <img class="listing-photo" [src]="housingLocation?.photo">
      <section class="listing-description">
        <h2 class="listing-heading">{{housingLocation?.name}}</h2>
        <p class="listing-location">{{housingLocation?.city}}, 
        {{housingLocation?.state}}
      </section>
      <section class="listing-features">
        <h2 class="section-heading">About the housing location</h2>
        <ul>
          <li><h5>Units available: {{housingLocation?.availableUnits}}</h5></li><br>
          <li><h5>Does this location have wifi: {{housingLocation?.wifi}}</h5></li><br>
          <li><h5>Does this location have laundry: {{housingLocation?.laundry}}</h5></li>
        </ul>
      </section>
      <section class="listing-apply">
        <h2 class="section-heading">Apply now to live here</h2>
        <form [formGroup]="applyForm" (submit)="submitApplication()">
         <label for="first-Name">First Name</label>
          <input id="first-Name" type="text" formControlName="firstName">
          <label for="last-Name">Last Name</label>
          <input id="last-Name" type="text" formControlName="lastName">
          <label for="email">Email</label>
          <input id="email" type="email" formControlName="email">
          <button type="submit" class="primary">Apply Now</button>
        
        </form>
      </section>
    </article>  
  `,
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);

  housingService = inject(HousingService);


  housingLocation : HousingLocation | undefined;

 

  applyForm : FormGroup;

//   applyForm = new FormGroup({
//     firstName : new FormControl(''),
//     lastName : new FormControl(''),
//     email : new FormControl('')
//   } );
// data: any;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {
    const housingLocationId = Number(this.route.snapshot.params['id']);
    this.housingService.getAllHousingLocationById(housingLocationId).then(housingLocation => {
      this.housingLocation = housingLocation;
    })
    this.applyForm = this.formBuilder.group({
      firstName : '',
      lastName : '',
      email : ''
    });
  }
  // submitApplication() {
  //   this.housingService.submitApplication(
  //     this.applyForm.value.firstName ?? '',
  //     this.applyForm.value.lastName ?? '',
  //     this.applyForm.value.email ?? ''
  //   );
  // }
  submitApplication() {
    this.http.post('http://localhost:8080/clients', this.applyForm.value).subscribe({
      next: () => {
        alert('Applied Successfully');
      },
      error : (err: any) => {
        console.error(err);
      }
    });
  }
}
 