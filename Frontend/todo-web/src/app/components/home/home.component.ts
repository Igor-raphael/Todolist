import { NgOptimizedImage, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from '../modal/modal.component';
import { ListService } from '../../services/list-service';
import { Observable } from 'rxjs';
import { Tarefas } from '../../model/tarefas';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgOptimizedImage, ModalComponent, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  tarefas$: Observable<Tarefas[]>;

  constructor( private listService: ListService){

    this.tarefas$ = this.listService.list();

  }


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
