import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-modal',
  imports: [NgIf, FormsModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent {

  showForm: boolean = false;
  overlay: boolean = false;

  text: string = '';

  formToggle(){
    this.showForm = !this.showForm;
    this.overlay = !this.overlay;
  }

  isLiberado(): boolean{

    let liberado : boolean = false;

    if(this.text == ''){
          return liberado = true;
    }

    return liberado;
  }

}
