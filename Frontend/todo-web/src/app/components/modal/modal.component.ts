import { Component } from '@angular/core';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-modal',
  imports: [NgIf],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent {

  showForm: boolean = false;
  overlay: boolean = false;

  formToggle(){
    this.showForm = !this.showForm;
    this.overlay = !this.overlay;
  }

}
