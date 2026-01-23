import { NgIf, NgOptimizedImage, NgClass } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from '../modal/modal.component';

@Component({
  selector: 'app-home',
  imports: [NgOptimizedImage, NgIf, NgClass, ModalComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

   description: boolean = false;
   done: boolean = false;

  toggleDescription(){
    this.description = !this.description;
  }

  isDone(){
    this.done = !this.done;
  }

  @ViewChild(ModalComponent) modal!: ModalComponent;

  showModal(){
     this.modal.formToggle();
  }

}
