import { NgIf, NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [NgOptimizedImage, NgIf],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

   description = false;

  toggleDescription(){
    this.description = !this.description;
  }

  if (description = true) {



  }

}
